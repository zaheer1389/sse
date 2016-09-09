package com.ssengineering.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssengineering.model.PurchaseDetail;
import com.ssengineering.model.SaleDetail;

@Repository
public class SaleDetailDAOImpl implements SaleDetailDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<SaleDetail> getSaleDetails() {
		// TODO Auto-generated method stub		
		return this.sessionFactory.getCurrentSession().createQuery("from SaleDetail").list();
	}

	@Override
	public void addSaleDetail(SaleDetail saleDetail) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(saleDetail);
	}

	@Override
	public void updateSaleDetail(SaleDetail saleDetail) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(saleDetail);
	}

	@Override
	public void deleteSaleDetail(Long id) {
		// TODO Auto-generated method stub
		SaleDetail saleDetail = (SaleDetail)this.sessionFactory.getCurrentSession().load(SaleDetail.class, id);
		if(saleDetail != null){
			this.sessionFactory.getCurrentSession().delete(saleDetail);
		}
	}

	@Override
	public SaleDetail getSaleDetailById(Long id) {
		// TODO Auto-generated method stub
		SaleDetail saleDetail = (SaleDetail)this.sessionFactory.getCurrentSession().get(SaleDetail.class, id);
		return saleDetail;
	}

	@Override
	public List<SaleDetail> getSaleDetailsBySaleId(Long saleId) {
		// TODO Auto-generated method stub
		String queryStr = "select sd from SaleDetail as sd join sd.sale as s where  s.id = :id";
		System.out.println(queryStr);
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setParameter("id", saleId);
		return query.list();
	}

}
