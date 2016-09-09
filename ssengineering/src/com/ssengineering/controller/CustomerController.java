package com.ssengineering.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import com.ssengineering.model.Customer;
import com.ssengineering.model.Part;
import com.ssengineering.model.SubPart;
import com.ssengineering.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public  String getCustomers(ModelMap map) {		
		map.addAttribute("customer", new Customer());
		map.put("customers", customerService.getCustomers());
		
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(customerService.getCustomers(), new TypeToken<List<Customer>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String jsonData = jsonArray.toString();
		map.addAttribute("jsonData", jsonData);
		System.out.println("json"+jsonData);
		return "customer";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public  String add(@ModelAttribute(value = "customer") Customer customer
			,@RequestParam(value = "type") String type
			,@RequestParam(value = "state") String state
			,@RequestParam(value = "country") String country
			,BindingResult result) {
		
		customer.setCustomerType(CustomerType.valueOf(type));
		customer.setState(state);
		customer.setCountry(country);
		customerService.addCustomer(customer);
		
		return "redirect:/customer/";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public  String edit(@RequestParam(value = "id") String id
			,@RequestParam(value = "name") String name
			,@RequestParam(value = "type") String type
			,@RequestParam(value = "address") String address
			,@RequestParam(value = "state") String state
			,@RequestParam(value = "country") String country
			,@RequestParam(value = "postalCode") String postalCode
			,@RequestParam(value = "tinNo") String tinNo
			,@RequestParam(value = "contactNo") String contactNo
			,@RequestParam(value = "email") String email) {		
		
		Long custId = Long.parseLong(id);
		Customer customer = customerService.getCustomerById(custId);
		
		if(customer != null){
			customer.setName(name);
			customer.setCustomerType(CustomerType.valueOf(type));
			customer.setAddress(address);
			customer.setState(state);
			customer.setCountry(country);
			customer.setPostalCode(postalCode);
			customer.setTinNo(tinNo);
			customer.setContactNo(contactNo);
			customer.setEmail(email);
			customerService.updateCustomer(customer);
		}
		
		return "redirect:/customer/";
	}
	

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/";
	}
	
	@RequestMapping(value = "getcustomer", method = RequestMethod.GET)
	public @ResponseBody String getCustome(@RequestParam(value = "id") String id) {
		Long custId = Long.parseLong(id);
		Customer customer = customerService.getCustomerById(custId);
		Hibernate.initialize(customer);
		//System.out.println("Part : "+part);
		String str = "{\"customer\": { \"name\": \"" + customer.getName()				
				+ "\",\"type\": \""  + customer.getCustomerType()
				+ "\",\"id\": \""  + customer.getId()
				+ "\",\"address\": \""  + customer.getAddress()
				+ "\",\"state\": \""  + customer.getState()
				+ "\",\"country\": \""  + customer.getCountry()
				+ "\",\"postalCode\": \""  + customer.getPostalCode()
				+ "\",\"tinNo\": \""  + customer.getTinNo()
				+ "\",\"contactNo\": \""  + customer.getContactNo()
				+ "\",\"email\": \""  + customer.getEmail()
				+ "\"}}"; 
		System.out.println("json"+str);
		return str;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
}
