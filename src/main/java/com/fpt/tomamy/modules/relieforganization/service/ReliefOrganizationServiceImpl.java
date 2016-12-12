package com.fpt.tomamy.modules.relieforganization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.relieforganization.dao.ReliefOrganizationDAO;
import com.fpt.tomamy.modules.relieforganization.model.ReliefOrganization;

import java.util.List;

@Service("ReliefOrganization")
public class ReliefOrganizationServiceImpl implements ReliefOrganizationService{
	@Autowired
	ReliefOrganizationDAO reliefOrganizationDAO;
	
	public List<ReliefOrganization> list(){
		return reliefOrganizationDAO.list();
	}
}
