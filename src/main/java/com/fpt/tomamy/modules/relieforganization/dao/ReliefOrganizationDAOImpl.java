package com.fpt.tomamy.modules.relieforganization.dao;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fpt.tomamy.dao.BaseDao;
import com.fpt.tomamy.modules.relieforganization.model.ReliefOrganization;

import java.util.List;

@Repository("ReliefOrganizationDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class ReliefOrganizationDAOImpl extends BaseDao implements ReliefOrganizationDAO{
	
	
	public List<ReliefOrganization> list(){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(ReliefOrganization.class);
			List<ReliefOrganization> list = criteria.list();
			commit();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			flush();
			close();
		}
	}
}
