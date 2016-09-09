package com.ssengineering.form;

import java.util.List;

import com.ssengineering.model.Purchase;
import com.ssengineering.model.PurchaseDetail;

public class PurchaseForm {

	Purchase purchase;	
	List<PurchaseDetail> purchaseDetails;
	
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	
	
}
