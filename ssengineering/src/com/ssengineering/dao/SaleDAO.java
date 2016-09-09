package com.ssengineering.dao;

import java.util.List;

import com.ssengineering.model.Purchase;
import com.ssengineering.model.Sale;

public interface SaleDAO {
	public List<Sale> getSales();
	public void addSale(Sale sale);
	public void updateSale(Sale sale);
	public void deleteSale(Long id);
	public Sale getSaleById(Long id);
}
