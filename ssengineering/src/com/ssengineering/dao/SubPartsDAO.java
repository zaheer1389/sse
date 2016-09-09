package com.ssengineering.dao;

import java.util.List;

import com.ssengineering.model.Part;
import com.ssengineering.model.SubPart;

public interface SubPartsDAO {
	
	public void addSubPart(SubPart part);
	public void updateSubPart(SubPart part);
	public void deleteSubPart(Long id);
	public List<SubPart> getSubParts();
	public SubPart getSubPartById(Long id);

}
