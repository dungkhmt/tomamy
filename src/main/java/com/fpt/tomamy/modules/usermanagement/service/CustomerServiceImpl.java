package com.fpt.tomamy.modules.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.usermanagement.dao.CustomerDAO;
import com.fpt.tomamy.modules.usermanagement.model.Customer;



@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired 
	private CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getList() {
		// TODO Auto-generated method stub
		return customerDAO.getList();
	}

	@Override
	public Customer getByCode(String cus_code) {
		// TODO Auto-generated method stub
		return customerDAO.getByCode(cus_code);
	}

}
