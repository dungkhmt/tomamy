package com.fpt.tomamy.modules.usermanagement.dao;

import java.util.List;

import com.fpt.tomamy.modules.usermanagement.model.Role;



public interface RoleDAO {
	
	public List<Role> getList();
	public Role getByName(String name);
	
}
