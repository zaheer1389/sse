package com.ssengineering.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssengineering.model.Part;
import com.ssengineering.model.Purchase;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Purchase> getPurchases() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Purchase").list();
	}

	@Override
	public void addPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(purchase);
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(purchase);
	}

	@Override
	public void deletePurchase(Long id) {
		// TODO Auto-generated method stub
		Purchase purchase = (Purchase)this.sessionFactory.getCurrentSession().load(Purchase.class, id);
		if(purchase != null){
			this.sessionFactory.getCurrentSession().delete(purchase);
		}
	}

	@Override
	public Purchase getPurchaseById(Long id) {
		// TODO Auto-generated method stub
		Purchase purchase = (Purchase)sessionFactory.getCurrentSession().get(Purchase.class, id);
		return purchase;
	}
	
}
