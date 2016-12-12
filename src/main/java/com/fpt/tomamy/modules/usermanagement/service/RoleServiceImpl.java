package com.fpt.tomamy.modules.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.usermanagement.dao.RoleDAO;
import com.fpt.tomamy.modules.usermanagement.model.Role;



@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;	
	
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public List<Role> getList(){
		return roleDAO.getList();
	}
	public Role getByName(String name){
		return roleDAO.getByName(name);
	}

}
