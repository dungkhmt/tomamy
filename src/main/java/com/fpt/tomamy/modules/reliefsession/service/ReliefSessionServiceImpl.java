package com.fpt.tomamy.modules.reliefsession.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.reliefsession.dao.ReliefSessionDAO;
import com.fpt.tomamy.modules.reliefsession.model.ReliefSession;

@Service("ReliefSession")
public class ReliefSessionServiceImpl implements ReliefSessionService{
	@Autowired
	ReliefSessionDAO reliefSessionDAO;
	public List<ReliefSession> list(){
		return reliefSessionDAO.list();
	}
}
