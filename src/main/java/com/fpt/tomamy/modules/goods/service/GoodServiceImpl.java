package com.fpt.tomamy.modules.goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.goods.dao.GoodDAO;
import com.fpt.tomamy.modules.goods.model.Good;

import java.util.List;

@Service("Good")
public class GoodServiceImpl implements GoodService{
	@Autowired
	GoodDAO goodDAO;
	
	public List<Good> list(){
		return goodDAO.list();
	}
}
