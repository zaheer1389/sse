package com.ssengineering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssengineering.dao.CustomerDAO;
import com.ssengineering.enums.CustomerType;
import com.ssengineering.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.updateCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerById(id);
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getCustomersByType(CustomerType type) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomersByType(type);
	}
	
	

}
