package com.ssengineering.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssengineering.enums.CustomerType;
import com.ssengineering.model.Customer;
import com.ssengineering.model.Part;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		Customer customer = (Customer)sessionFactory.getCurrentSession().load(Customer.class, id);
		if(customer != null){
			this.sessionFactory.getCurrentSession().delete(customer);
		}
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		Customer customer = (Customer)sessionFactory.getCurrentSession().get(Customer.class, id);
		return customer;
	}

	@Override
	public List<Customer> getCustomersByType(CustomerType type) {
		// TODO Auto-generated method stub
		String queryStr = "select c from Customer as c where  c.customerType = :type";
		System.out.println(queryStr);
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setParameter("type", type);
		return query.list();
	}

}
