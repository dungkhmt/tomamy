package com.fpt.tomamy.modules.usermanagement.service;

import java.util.List;

import com.fpt.tomamy.modules.usermanagement.model.MsoMember;



public interface MemberService {
	
	public List<MsoMember> getList();
	public MsoMember getByID(int id);
	public int save(String name, String role);
	public int delete(int id);

}
