package com.ssengineering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssengineering.dao.PurchaseDAO;
import com.ssengineering.dao.PurchaseDetailDAO;
import com.ssengineering.model.Purchase;
import com.ssengineering.model.PurchaseDetail;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService{
	
	@Autowired
	private PurchaseDetailDAO purchaseDetailDAO;
	
	@Override
	@Transactional
	public List<PurchaseDetail> getPurchaseDetails() {
		// TODO Auto-generated method stub
		return purchaseDetailDAO.getPurchaseDetails();
	}

	@Override
	@Transactional
	public void addPurchaseDetail(PurchaseDetail purchaseDetail) {
		// TODO Auto-generated method stub
		purchaseDetailDAO.addPurchaseDetail(purchaseDetail);
	}

	@Override
	@Transactional
	public void updatePurchaseDetail(PurchaseDetail purchaseDetail) {
		// TODO Auto-generated method stub
		purchaseDetailDAO.updatePurchaseDetail(purchaseDetail);
	}

	@Override
	@Transactional
	public void deletePurchaseDetail(Long id) {
		// TODO Auto-generated method stub
		purchaseDetailDAO.deletePurchaseDetail(id);
	}

	@Override
	@Transactional
	public PurchaseDetail getPurchaseDetailById(Long id) {
		// TODO Auto-generated method stub
		return purchaseDetailDAO.getPurchaseDetailById(id);
	}
	
	@Override
	@Transactional
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseId(Long id) {
		// TODO Auto-generated method stub
		return purchaseDetailDAO.getPurchaseDetailsByPurchaseId(id);
	}

	public void setPurchaseDetailDAO(PurchaseDetailDAO purchaseDetailDAO) {
		this.purchaseDetailDAO = purchaseDetailDAO;
	}

	
}
