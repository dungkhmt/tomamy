package com.fpt.tomamy.modules.usermanagement.dao;

import com.fpt.tomamy.modules.usermanagement.model.StaffCustomer;



public interface StaffCustomerDAO {
	public StaffCustomer getCusCodeByUsername(String userName);
}
