package com.fpt.tomamy.modules.usermanagement.service;

import java.util.HashSet;
import java.util.List;

import com.fpt.tomamy.modules.usermanagement.model.Role;
import com.fpt.tomamy.modules.usermanagement.model.User;



public interface UserService {
	
	public List<User> getList();
	public User getByID(int id);
	public User getByUsernameAndPassword(String username, String password);
	public User getByUsername(String username);
	public int save(String username, String password, HashSet<Role> roles);
	public int delete(int id);

}
