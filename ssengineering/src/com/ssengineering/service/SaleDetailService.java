package com.ssengineering.service;

import java.util.List;

import com.ssengineering.model.Purchase;
import com.ssengineering.model.Sale;
import com.ssengineering.model.SaleDetail;

public interface SaleDetailService {
	public List<SaleDetail> getSaleDetails();
	public void addSaleDetail(SaleDetail saleDetail);
	public void updateSaleDetail(SaleDetail saleDetail);
	public void deleteSaleDetail(Long id);
	public SaleDetail getSaleDetailById(Long id);
	public List<SaleDetail> getSaleDetailsBySaleId(Long saleId);
}
