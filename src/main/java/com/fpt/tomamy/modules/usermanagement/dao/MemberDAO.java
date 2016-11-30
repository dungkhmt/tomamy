package com.fpt.tomamy.modules.usermanagement.dao;

import java.util.List;

import com.fpt.tomamy.modules.usermanagement.model.MsoMember;




public interface MemberDAO {
	
	public List<MsoMember> getList();
	public MsoMember getByID(int id);
	public int save(MsoMember member);
	public int delete(MsoMember member);
	
	
}
