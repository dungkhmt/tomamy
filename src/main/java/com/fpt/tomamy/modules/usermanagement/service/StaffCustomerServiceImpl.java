package com.fpt.tomamy.modules.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.usermanagement.dao.StaffCustomerDAO;
import com.fpt.tomamy.modules.usermanagement.model.StaffCustomer;


@Service("StaffCustomerService")
public class StaffCustomerServiceImpl implements StaffCustomerService {
	
	@Autowired
	StaffCustomerDAO staffCustomerDAO;
	
	@Override
	public StaffCustomer getCusCodeByUserName(String username) {
		// TODO Auto-generated method stub
		return staffCustomerDAO.getCusCodeByUsername(username);
	}

}
