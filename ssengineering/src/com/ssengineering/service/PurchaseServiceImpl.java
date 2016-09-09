package com.ssengineering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssengineering.dao.PurchaseDAO;
import com.ssengineering.model.Purchase;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private PurchaseDAO purchaseDAO;
	
	@Override
	@Transactional
	public List<Purchase> getPurchases() {
		// TODO Auto-generated method stub
		return purchaseDAO.getPurchases();
	}

	@Override
	@Transactional
	public void addPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		purchaseDAO.addPurchase(purchase);
	}

	@Override
	@Transactional
	public void updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		purchaseDAO.updatePurchase(purchase);
	}

	@Override
	@Transactional
	public void deletePurchase(Long id) {
		// TODO Auto-generated method stub
		purchaseDAO.deletePurchase(id);
	}

	@Override
	@Transactional
	public Purchase getPurchaseById(Long id) {
		// TODO Auto-generated method stub
		return purchaseDAO.getPurchaseById(id);
	}

	public void setPurchaseDAO(PurchaseDAO purchaseDAO) {
		this.purchaseDAO = purchaseDAO;
	}

	
}
