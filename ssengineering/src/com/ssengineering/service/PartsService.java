package com.ssengineering.service;

import java.util.List;

import com.ssengineering.model.Part;

public interface PartsService {
	public void addPart(Part part);
	public void deletePart(Long id);
	public List<Part> getParts();
	public Part getPartById(Long id);
	public void updatePart(Part part);
}
