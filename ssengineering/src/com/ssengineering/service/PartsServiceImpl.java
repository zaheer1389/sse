package com.ssengineering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssengineering.dao.PartsDAO;
import com.ssengineering.model.Part;

@Service
public class PartsServiceImpl implements PartsService{

	@Autowired
	private PartsDAO partsDAO;
	
	@Override
	@Transactional
	public void addPart(Part part) {
		// TODO Auto-generated method stub
		partsDAO.addPart(part);
	}

	@Override
	@Transactional
	public void deletePart(Long id) {
		// TODO Auto-generated method stub
		partsDAO.deletePart(id);
	}

	@Override
	@Transactional
	public List<Part> getParts() {
		// TODO Auto-generated method stub
		return partsDAO.getParts();
	}

	public void setPartsDAO(PartsDAO partsDAO) {
		this.partsDAO = partsDAO;
	}

	@Override
	@Transactional
	public Part getPartById(Long id) {
		// TODO Auto-generated method stub
		return partsDAO.getPartById(id);
	}

	@Override
	@Transactional
	public void updatePart(Part part) {
		// TODO Auto-generated method stub
		partsDAO.updatePart(part);
	}
	
	

}
