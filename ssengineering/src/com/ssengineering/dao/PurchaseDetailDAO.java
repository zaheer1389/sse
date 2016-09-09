package com.ssengineering.dao;

import java.util.List;

import com.ssengineering.model.PurchaseDetail;

public interface PurchaseDetailDAO {
	public List<PurchaseDetail> getPurchaseDetails();
	public void addPurchaseDetail(PurchaseDetail purchaseDetail);
	public void updatePurchaseDetail(PurchaseDetail purchaseDetail);
	public void deletePurchaseDetail(Long id);
	public PurchaseDetail getPurchaseDetailById(Long id);
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseId(Long purchaseId);
}
