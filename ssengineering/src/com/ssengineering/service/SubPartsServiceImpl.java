package com.ssengineering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssengineering.dao.PartsDAO;
import com.ssengineering.dao.SubPartsDAO;
import com.ssengineering.model.Part;
import com.ssengineering.model.SubPart;

@Service
public class SubPartsServiceImpl implements SubPartsService{

	@Autowired
	private SubPartsDAO subPartsDAO;
	
	@Override
	@Transactional
	public void addSubPart(SubPart part) {
		// TODO Auto-generated method stub
		subPartsDAO.addSubPart(part);
	}

	@Override
	@Transactional
	public void deleteSubPart(Long id) {
		// TODO Auto-generated method stub
		subPartsDAO.deleteSubPart(id);
	}

	@Override
	@Transactional
	public List<SubPart> getSubParts() {
		// TODO Auto-generated method stub
		return subPartsDAO.getSubParts();
	}

	public void setSubPartsDAO(SubPartsDAO partsDAO) {
		this.subPartsDAO = partsDAO;
	}

	@Override
	@Transactional
	public SubPart getSubPartById(Long id) {
		// TODO Auto-generated method stub
		return subPartsDAO.getSubPartById(id);
	}

	@Override
	@Transactional
	public void updateSubPart(SubPart part) {
		// TODO Auto-generated method stub
		subPartsDAO.updateSubPart(part);
	}
	
	

}
