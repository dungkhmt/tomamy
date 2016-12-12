package com.fpt.tomamy.modules.goods.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.fpt.tomamy.dao.BaseDao;
import com.fpt.tomamy.modules.goods.model.Good;

@Repository("GoodDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class GoodDAOImpl extends BaseDao implements GoodDAO{
	public List<Good> list(){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(Good.class);
			List<Good> L = criteria.list();
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
