package com.ssengineering.dao;

import java.util.List;

import com.ssengineering.model.Part;

public interface PartsDAO {
	
	public void addPart(Part part);
	public void updatePart(Part part);
	public void deletePart(Long id);
	public List<Part> getParts();
	public Part getPartById(Long id);

}
