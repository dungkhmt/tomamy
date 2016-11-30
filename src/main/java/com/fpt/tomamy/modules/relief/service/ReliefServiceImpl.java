package com.fpt.tomamy.modules.relief.service;

import com.fpt.tomamy.modules.relief.dao.ReliefDAO;
import com.fpt.tomamy.modules.relief.model.Relief;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Relief")
public class ReliefServiceImpl implements ReliefService{
	@Autowired
	ReliefDAO reliefDAO;
	public List<Relief> list(){
		return reliefDAO.list();
	}
}
