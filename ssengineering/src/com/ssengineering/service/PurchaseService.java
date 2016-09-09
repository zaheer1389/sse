package com.ssengineering.service;

import java.util.List;

import com.ssengineering.model.Purchase;

public interface PurchaseService {
	public List<Purchase> getPurchases();
	public void addPurchase(Purchase purchase);
	public void updatePurchase(Purchase purchase);
	public void deletePurchase(Long id);
	public Purchase getPurchaseById(Long id);
}
