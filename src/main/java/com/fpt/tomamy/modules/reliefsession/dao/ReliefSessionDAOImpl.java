package com.fpt.tomamy.modules.reliefsession.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fpt.tomamy.dao.BaseDao;
import com.fpt.tomamy.modules.reliefsession.model.ReliefSession;

@Repository("ReliefSessionDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class ReliefSessionDAOImpl extends BaseDao implements ReliefSessionDAO{
	public List<ReliefSession> list(){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(ReliefSession.class);
			List<ReliefSession> L = criteria.list();
			commit();
			System.out.println("ReliefSessionDAOImpl, L.sz = " + L.size());
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
