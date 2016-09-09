package com.ssengineering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssengineering.dao.SaleDetailDAO;
import com.ssengineering.model.SaleDetail;

@Service
public class SaleDetailServiceImpl implements SaleDetailService{

	@Autowired
	private SaleDetailDAO saleDetailDAO;
	
	@Override
	@Transactional
	public List<SaleDetail> getSaleDetails() {
		// TODO Auto-generated method stub
		return saleDetailDAO.getSaleDetails();
	}

	@Override
	@Transactional
	public void addSaleDetail(SaleDetail saleDetail) {
		// TODO Auto-generated method stub
		saleDetailDAO.addSaleDetail(saleDetail);
	}

	@Override
	@Transactional
	public void updateSaleDetail(SaleDetail saleDetail) {
		// TODO Auto-generated method stub
		saleDetailDAO.updateSaleDetail(saleDetail);
	}

	@Override
	@Transactional
	public void deleteSaleDetail(Long id) {
		// TODO Auto-generated method stub
		saleDetailDAO.deleteSaleDetail(id);
	}

	@Override
	@Transactional
	public SaleDetail getSaleDetailById(Long id) {
		// TODO Auto-generated method stub
		return saleDetailDAO.getSaleDetailById(id);
	}

	@Override
	@Transactional
	public List<SaleDetail> getSaleDetailsBySaleId(Long saleId) {
		// TODO Auto-generated method stub
		return saleDetailDAO.getSaleDetailsBySaleId(saleId);
	}

	public void setSaleDetailDAO(SaleDetailDAO saleDetailDAO) {
		this.saleDetailDAO = saleDetailDAO;
	}
	
	

}
