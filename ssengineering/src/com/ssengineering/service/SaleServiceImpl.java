package com.ssengineering.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssengineering.dao.SaleDAO;
import com.ssengineering.model.Purchase;
import com.ssengineering.model.Sale;

@Service
public class SaleServiceImpl implements SaleService{

	@Autowired
	private SaleDAO saleDAO;
	
	@Override
	@Transactional
	public List<Sale> getSales() {
		// TODO Auto-generated method stub
		return saleDAO.getSales();
	}
	
	@Override
	@Transactional
	public void addSale(Sale sale) {
		// TODO Auto-generated method stub
		saleDAO.addSale(sale);
	}

	
	@Override
	@Transactional
	public void updateSale(Sale sale) {
		// TODO Auto-generated method stub
		saleDAO.updateSale(sale);
	}

	
	@Override
	@Transactional
	public void deleteSale(Long id) {
		// TODO Auto-generated method stub
		saleDAO.deleteSale(id);
	}

	
	@Override
	@Transactional
	public Sale getSaleById(Long id) {
		// TODO Auto-generated method stub
		Sale sale = saleDAO.getSaleById(id);
		return sale;
	}

	public void setSaleDAO(SaleDAO saleDAO) {
		this.saleDAO = saleDAO;
	}
	
	

}
