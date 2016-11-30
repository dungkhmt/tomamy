package com.fpt.tomamy.modules.relief.dao;

import com.fpt.tomamy.dao.BaseDao;
import com.fpt.tomamy.modules.relief.model.Relief;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
@Repository("ReliefDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class ReliefDAOImpl extends BaseDao implements ReliefDAO{
	public List<Relief> list(){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(Relief.class);
			List<Relief> L = criteria.list();
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
