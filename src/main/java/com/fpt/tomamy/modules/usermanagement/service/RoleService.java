package com.fpt.tomamy.modules.usermanagement.service;

import java.util.List;

import com.fpt.tomamy.modules.usermanagement.model.Role;




public interface RoleService {
	
	public List<Role> getList();
	public Role getByName(String name);

}
