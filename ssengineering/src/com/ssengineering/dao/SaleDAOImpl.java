package com.ssengineering.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssengineering.model.Purchase;
import com.ssengineering.model.Sale;

@Repository
public class SaleDAOImpl implements SaleDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Sale> getSales() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Sale").list();
	}

	@Override
	public void addSale(Sale sale) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(sale);
	}

	@Override
	public void updateSale(Sale sale) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(sale);
	}

	@Override
	public void deleteSale(Long id) {
		// TODO Auto-generated method stub
		Sale sale = (Sale)this.sessionFactory.getCurrentSession().load(Sale.class, id);
		if(sale != null){
			this.sessionFactory.getCurrentSession().delete(sale);
		}
	}

	@Override
	public Sale getSaleById(Long id) {
		// TODO Auto-generated method stub
		Sale sale = (Sale)this.sessionFactory.getCurrentSession().get(Sale.class, id);
		return sale;
	}
	
	

}
