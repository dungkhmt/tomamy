package com.fpt.tomamy.modules.regionmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.regionmanagement.dao.CommuneDAO;
import com.fpt.tomamy.modules.regionmanagement.model.Commune;

import java.util.List;

@Service("Commune")
public class CommuneServiceImpl implements CommuneService{
	@Autowired
	CommuneDAO communeDAO;
	
	public List<Commune> list(){
		return communeDAO.list();
	}
}
