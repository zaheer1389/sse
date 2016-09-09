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
import com.ssengineering.model.Part;
import com.ssengineering.service.PartsService;


@Controller
@RequestMapping("/parts")
public class PartsController {
	
	@Autowired
	private PartsService partsService;

	@RequestMapping(value = "/part/{id}", method = RequestMethod.GET)
	public @ResponseBody String data(@PathVariable("id") Long id){
		Part part = partsService.getPartById(id);
		Hibernate.initialize(part);
		//System.out.println("Part : "+part);
		String str = "{\"result\":\"Success\",\"part\": { \"name\": \"" + part.getName() 
				+ "\",\"desc\": \""  + part.getDescription()
				+ "\",\"id\": \""  + part.getId()
				+ "\"}}"; 
		return str;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public  String getPasrts(ModelMap map) {
		
		/*for(int i=0; i<1000000; i++){
			Part part = new Part();
			part.setName("Parts "+i);
			part.setDescription("Parts "+i);
			partsService.addPart(part);
		}*/
		
		map.addAttribute("part", new Part());
		map.put("parts", partsService.getParts());
		
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(partsService.getParts(), new TypeToken<List<Part>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String jsonData = jsonArray.toString();
		map.addAttribute("jsonData", jsonData);
		
		return "parts";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public  String add(@ModelAttribute(value = "part") Part part,BindingResult result) {		
		partsService.addPart(part);
		return "redirect:/parts/";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public  String edit(@RequestParam(value = "id") String id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String desc) {		
		
		Long partId = Long.parseLong(id);
		Part part = partsService.getPartById(partId);
		
		if(part != null){
			part.setId(partId);
			part.setName(name);
			part.setDescription(desc);
			partsService.updatePart(part);
		}
		
		return "redirect:/parts/";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		partsService.deletePart(id);
		return "redirect:/parts/";
	}
	
	@RequestMapping(value = "getpart", method = RequestMethod.GET)
	public @ResponseBody String getPart(@RequestParam(value = "id") String id) {
		Long partId = Long.parseLong(id);
		Part part = partsService.getPartById(partId);
		Hibernate.initialize(part);
		//System.out.println("Part : "+part);
		String str = "{\"part\": { \"name\": \"" + part.getName() 
				+ "\",\"desc\": \""  + part.getDescription()
				+ "\",\"id\": \""  + part.getId()
				+ "\"}}"; 
		return str;
	}
	
	public void setPartsService(PartsService partsService) {
		this.partsService = partsService;
	}
	
	
}
