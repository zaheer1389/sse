package com.ssengineering.service;

import java.util.List;

import com.ssengineering.model.Part;
import com.ssengineering.model.SubPart;

public interface SubPartsService {
	public void addSubPart(SubPart part);
	public void deleteSubPart(Long id);
	public List<SubPart> getSubParts();
	public SubPart getSubPartById(Long id);
	public void updateSubPart(SubPart part);
}
