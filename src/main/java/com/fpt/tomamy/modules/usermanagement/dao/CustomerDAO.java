package com.fpt.tomamy.modules.usermanagement.dao;

import java.util.List;

import com.fpt.tomamy.modules.usermanagement.model.Customer;


public interface CustomerDAO {
	public List<Customer> getList();
	public Customer getByCode(String cus_code);
}
