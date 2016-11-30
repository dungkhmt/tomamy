package com.fpt.tomamy.modules.reliefdemand.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fpt.tomamy.dao.BaseDao;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;

@Repository("ReliefDemandDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class ReliefDemandDAOImpl extends BaseDao implements ReliefDemandDAO{
	public List<ReliefDemand> list(){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(ReliefDemand.class);
			List<ReliefDemand> listReliefDemands = criteria.list();
			commit();
			return listReliefDemands;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			flush();
	        close();
		}
	}
}
