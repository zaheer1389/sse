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
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ssengineering.model.Part;
import com.ssengineering.model.SubPart;
import com.ssengineering.service.PartsService;
import com.ssengineering.service.SubPartsService;


@Controller
@RequestMapping("/subparts")
public class SubPartsController {
	
	@Autowired
	private SubPartsService subPartsService;
	
	@Autowired
	private PartsService partsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public  String getPasrts(ModelMap map) {		
		map.addAttribute("subpart", new SubPart());
		map.put("subparts", subPartsService.getSubParts());
		map.put("parts", partsService.getParts());
		
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(subPartsService.getSubParts(), new TypeToken<List<Part>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String jsonData = jsonArray.toString();
		System.out.println("json : "+jsonData);
		map.addAttribute("jsonData", jsonData);
		
		//map.addAttribute("jsonData", toJSONString(subPartsService.getSubParts()));
		
		return "subparts";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public  String add(@ModelAttribute(value = "subpart") SubPart part
			,@RequestParam(value = "partId") String partId
			,BindingResult result) {
		Part p = partsService.getPartById(Long.parseLong(partId));
		part.setPart(p);
		subPartsService.addSubPart(part);
		return "redirect:/subparts/";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public  String edit(@RequestParam(value = "id") String id
			,@RequestParam(value = "name") String name
			,@RequestParam(value = "description") String desc
			,@RequestParam(value = "partId") String partId) {		
		
		Long subpartId = Long.parseLong(id);
		SubPart subpart = subPartsService.getSubPartById(subpartId);
		Part part = partsService.getPartById(Long.parseLong(partId));
		if(subpart != null){
			subpart.setId(subpartId);
			subpart.setName(name);
			subpart.setDescription(desc);
			subpart.setPart(part);
			subPartsService.updateSubPart(subpart);
		}
		
		return "redirect:/subparts/";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		subPartsService.deleteSubPart(id);
		return "redirect:/subparts/";
	}
	
	@RequestMapping(value = "getpart", method = RequestMethod.GET)
	public @ResponseBody String getPart(@RequestParam(value = "id") String id) {
		Long partId = Long.parseLong(id);
		SubPart part = subPartsService.getSubPartById(partId);
		Hibernate.initialize(part);
		//System.out.println("Part : "+part);
		String str = "{\"part\": { \"name\": \"" + part.getName()				
				+ "\",\"desc\": \""  + part.getDescription()
				+ "\",\"id\": \""  + part.getId()
				+ "\",\"partid\": \""  + part.getPart().getId()
				+ "\"}}"; 
		return str;
	}
	
	public void setSubPartsService(SubPartsService subPartsService) {
		this.subPartsService = subPartsService;
	}

	public void setPartsService(PartsService partsService) {
		this.partsService = partsService;
	}
	
	
	
}
