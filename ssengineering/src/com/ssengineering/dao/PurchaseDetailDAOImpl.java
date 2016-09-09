package com.ssengineering.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssengineering.model.Part;
import com.ssengineering.model.Purchase;
import com.ssengineering.model.PurchaseDetail;

@Repository
public class PurchaseDetailDAOImpl implements PurchaseDetailDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PurchaseDetail> getPurchaseDetails() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from PurchaseDetail").list();
	}

	@Override
	public void addPurchaseDetail(PurchaseDetail purchaseDetail) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(purchaseDetail);
	}

	@Override
	public void updatePurchaseDetail(PurchaseDetail purchaseDetail) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(purchaseDetail);
	}

	@Override
	public void deletePurchaseDetail(Long id) {
		// TODO Auto-generated method stub
		PurchaseDetail purchaseDetail = (PurchaseDetail)this.sessionFactory.getCurrentSession().load(PurchaseDetail.class, id);
		if(purchaseDetail != null){
			this.sessionFactory.getCurrentSession().delete(purchaseDetail);
		}
	}

	@Override
	public PurchaseDetail getPurchaseDetailById(Long id) {
		// TODO Auto-generated method stub
		PurchaseDetail purchaseDetail = (PurchaseDetail)sessionFactory.getCurrentSession().get(PurchaseDetail.class, id);
		return purchaseDetail;
	}
	
	@Override
	public List<PurchaseDetail> getPurchaseDetailsByPurchaseId(Long id) {
		// TODO Auto-generated method stub
		String queryStr = "select pd from PurchaseDetail as pd join pd.purchase as p where  p.id = :id";
		System.out.println(queryStr);
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setParameter("id", id);
		return query.list();
	}
	
}
