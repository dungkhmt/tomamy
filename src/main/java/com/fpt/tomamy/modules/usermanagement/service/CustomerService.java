package com.fpt.tomamy.modules.usermanagement.service;

import java.util.List;

import com.fpt.tomamy.modules.usermanagement.model.Customer;



public interface CustomerService {
	public List<Customer> getList();
	public Customer getByCode(String cus_code);
}
