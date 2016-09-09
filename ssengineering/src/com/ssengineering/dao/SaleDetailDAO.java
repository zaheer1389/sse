package com.ssengineering.dao;

import java.util.List;

import com.ssengineering.model.PurchaseDetail;
import com.ssengineering.model.SaleDetail;

public interface SaleDetailDAO {
	public List<SaleDetail> getSaleDetails();
	public void addSaleDetail(SaleDetail saleDetail);
	public void updateSaleDetail(SaleDetail saleDetail);
	public void deleteSaleDetail(Long id);
	public SaleDetail getSaleDetailById(Long id);
	public List<SaleDetail> getSaleDetailsBySaleId(Long saleId);
}
