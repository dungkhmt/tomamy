package com.fpt.tomamy.modules.regionmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fpt.tomamy.dao.BaseDao;
import com.fpt.tomamy.modules.regionmanagement.model.Commune;

@Repository("CommuneDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class CommuneDAOImpl extends BaseDao implements CommuneDAO{
	public List<Commune> list(){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(Commune.class);
			List<Commune> L = criteria.list();
			commit();
			return L;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			flush();
			close();
		}
	}
}
