package com.ssengineering.dao;

import java.util.List;

import com.ssengineering.enums.CustomerType;
import com.ssengineering.model.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Long id);
	public Customer getCustomerById(Long id);
	public List<Customer> getCustomersByType(CustomerType type);
	
}
