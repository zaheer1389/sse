package com.ssengineering.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.ssengineering.enums.CustomerType;
import com.ssengineering.form.PurchaseForm;
import com.ssengineering.model.Customer;
import com.ssengineering.model.Part;
import com.ssengineering.model.Purchase;
import com.ssengineering.model.PurchaseDetail;
import com.ssengineering.model.SubPart;
import com.ssengineering.service.CustomerService;
import com.ssengineering.service.PartsService;
import com.ssengineering.service.PurchaseDetailService;
import com.ssengineering.service.PurchaseService;
import com.ssengineering.service.SubPartsService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private PurchaseDetailService purchaseDetailService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PartsService partsService;
	
	@Autowired 
	private SubPartsService subPartsService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public  String getPurchases(ModelMap map) {				
		map.put("purchases", purchaseService.getPurchases());
		map.put("customers", customerService.getCustomers());
		map.put("parts", partsService.getParts());
		map.put("subparts", subPartsService.getSubParts());			
		map.addAttribute("jsonData", toPurchaseJSON());
		map.addAttribute("jsonPart", toPartsJSON());
		map.addAttribute("jsonSubpart", toSubPartsJSON());
		map.addAttribute("jsonCustomer", toCustomerJSON());
		
		System.out.println(toPurchaseJSON());
		
		return "purchase";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPurchases(HttpServletRequest request) {
		int totalItems = Integer.parseInt(request.getParameter("totalItems"));
		Long custId = Long.parseLong(request.getParameter("customerId"));
		
		Purchase purchase = new Purchase();
		purchase.setCustomer(customerService.getCustomerById(custId));
		purchase.setPurchaseDate(new Timestamp(new Date().getTime()));
		purchaseService.addPurchase(purchase);
		
		purchase = purchaseService.getPurchaseById(purchase.getId());
		Double totalAmount = 0d;
		
		for(int i = 0; i < totalItems; i++){
			Long partId = Long.parseLong(request.getParameter("part"+i));
			Long subPartId = Long.parseLong(request.getParameter("subpart"+i));
			int qty = Integer.parseInt(request.getParameter("qty"+i));
			Double amount = Double.parseDouble(request.getParameter("price"+i));
			
			PurchaseDetail pd = new PurchaseDetail();
			pd.setPurchase(purchase);
			pd.setPart(partsService.getPartById(partId));
			pd.setSubPart(subPartsService.getSubPartById(subPartId));
			pd.setTotalUnit(qty);
			pd.setAmountPerUnit(amount);
			purchaseDetailService.addPurchaseDetail(pd);
			
			totalAmount = totalAmount + (qty*amount);
		}
		
		purchase.setTotalAmount(totalAmount);
		purchaseService.updatePurchase(purchase);
		
		return "redirect:/purchase/";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editPurchases(HttpServletRequest request) {
		Long purchaseId = Long.parseLong(request.getParameter("purchaseId"));
		Purchase purchase = purchaseService.getPurchaseById(purchaseId);
		if(purchase != null){
			int totalItems = Integer.parseInt(request.getParameter("totalItems"));			
			Long custId = Long.parseLong(request.getParameter("customerId"));
			
			purchase.setCustomer(customerService.getCustomerById(custId));
			//purchase.setPurchaseDate(new Timestamp(new Date().getTime()));
			purchaseService.updatePurchase(purchase);
			
			purchase = purchaseService.getPurchaseById(purchase.getId());
			Double totalAmount = 0d;
			
			for(int i = 0; i < totalItems; i++){
				Long detailId = Long.parseLong(request.getParameter("id"+i));				
				String deleted = request.getParameter("deleted"+i);
				
				PurchaseDetail pd = purchaseDetailService.getPurchaseDetailById(detailId);
				if(pd != null && deleted != null && deleted.equalsIgnoreCase("on")){
					purchaseDetailService.deletePurchaseDetail(detailId);
					continue;
				}
				
				Long partId = Long.parseLong(request.getParameter("part"+i));
				Long subPartId = Long.parseLong(request.getParameter("subpart"+i));
				int qty = Integer.parseInt(request.getParameter("qty"+i));
				Double amount = Double.parseDouble(request.getParameter("price"+i));
				
				if(pd != null){					
					pd.setPurchase(purchase);
					pd.setPart(partsService.getPartById(partId));
					pd.setSubPart(subPartsService.getSubPartById(subPartId));
					pd.setTotalUnit(qty);
					pd.setAmountPerUnit(amount);
					purchaseDetailService.updatePurchaseDetail(pd);
				}
				else{
					pd = new PurchaseDetail();
					pd.setPurchase(purchase);
					pd.setPart(partsService.getPartById(partId));
					pd.setSubPart(subPartsService.getSubPartById(subPartId));
					pd.setTotalUnit(qty);
					pd.setAmountPerUnit(amount);
					purchaseDetailService.addPurchaseDetail(pd);
				}
				
				totalAmount = totalAmount + (qty*amount);
			}
			
			purchase.setTotalAmount(totalAmount);
			purchaseService.updatePurchase(purchase);
		}		
		return "redirect:/purchase/";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {				
		List<PurchaseDetail> details = purchaseDetailService.getPurchaseDetailsByPurchaseId(id);
		for(PurchaseDetail detail : details){
			if(detail != null){
				purchaseDetailService.deletePurchaseDetail(detail.getId());
			}
		}
		purchaseService.deletePurchase(id);
		return "redirect:/purchase/";
	}
	
	@RequestMapping(value = "getpurchasedetail", method = RequestMethod.GET)
	public @ResponseBody String getPurchaseDetail(@RequestParam(value = "id") String id) {
		Long purchaseId = Long.parseLong(id);
		List<PurchaseDetail> details = purchaseDetailService.getPurchaseDetailsByPurchaseId(purchaseId);		
		return toPurchaseDetailsJSON(details);
	}
	
	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	public void setPurchaseDetailService(PurchaseDetailService purchaseDetailService) {
		this.purchaseDetailService = purchaseDetailService;
	}
	
	public String toPurchaseJSON(){
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(purchaseService.getPurchases(), new TypeToken<List<Purchase>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String jsonData = jsonArray.toString();
		System.out.println("purchases : "+jsonData);
		return jsonData;
	}
	
	public String toCustomerJSON(){
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(customerService.getCustomersByType(CustomerType.PURCHASE), new TypeToken<List<Customer>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String jsonData = jsonArray.toString();
		System.out.println("customers : "+jsonData);
		return jsonData;
	}
	
	public String toPartsJSON(){
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(partsService.getParts(), new TypeToken<List<Part>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String jsonData = jsonArray.toString();
		System.out.println("parts : "+jsonData);
		return jsonData;
	}
	
	public String toSubPartsJSON(){
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(subPartsService.getSubParts(), new TypeToken<List<SubPart>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String jsonData = jsonArray.toString();
		System.out.println("subparts : "+jsonData);
		return jsonData;
	}
	
	public String toPurchaseDetailsJSON(List<PurchaseDetail> data){
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(data, new TypeToken<List<PurchaseDetail>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String jsonData = jsonArray.toString();
		System.out.println("purchase details : "+jsonData);
		return jsonData;
	}
}
