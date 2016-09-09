package com.ssengineering.service;

import java.util.List;

import com.ssengineering.model.PurchaseDetail;

public interface PurchaseDetailService {
	public List<PurchaseDetail> getPurchaseDetails();
	public void addPurchaseDetail(PurchaseDetail pd);
	public void updatePurchaseDetail(PurchaseDetail pd);
	public void deletePurchaseDetail(Long id);
	public PurchaseDetail getPurchaseDetailById(Long id);
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseId(Long purchaseId);
}
