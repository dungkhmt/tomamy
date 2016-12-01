package com.fpt.tomamy.modules.relief.dao;

import com.fpt.tomamy.dao.BaseDao;
import com.fpt.tomamy.modules.relief.model.Relief;
import com.fpt.tomamy.modules.relief.model.ReliefDetail;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
@Repository("ReliefDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class ReliefDAOImpl extends BaseDao implements ReliefDAO{
	
	public void updateAReliefDetail(ReliefDetail rd){
		try{
			begin();
			getSession().update(rd);
			commit();
			
		}catch(Exception ex){
			ex.printStackTrace();
			rollback();
			close();
			
		}finally{
			flush();
			close();
		}
	}
	public void updateARelief(Relief rl){
		try{
			begin();
			getSession().update(rl);
			commit();
			
		}catch(Exception ex){
			ex.printStackTrace();
			rollback();
			close();
			
		}finally{
			flush();
			close();
		}
	}
	public int saveAReliefDetail(ReliefDetail rd){
		try{
			begin();
			int id = (int)getSession().save(rd);
			commit();
			return id;
		}catch(Exception ex){
			ex.printStackTrace();
			rollback();
			close();
			return -1;
		}finally{
			flush();
			close();
		}
	}
	
	public int saveARelief(Relief rl){
		try{
			begin();
			int id = (int)getSession().save(rl);
			commit();
			return id;
		}catch(Exception ex){
			ex.printStackTrace();
			rollback();
			close();
			return -1;
		}finally{
			flush();
			close();
		}
	}
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
	
	public Relief getRelief(String reliefSessionCode, String reliefOrganizationCode, String communeCode){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(Relief.class);
			criteria.add(Restrictions.eq("RLF_ReliefOrganizationCode",reliefOrganizationCode));
			criteria.add(Restrictions.eq("RLF_ReliefSessionCode",reliefSessionCode));
			criteria.add(Restrictions.eq("RLF_CommuneCode",communeCode));
			List<Relief> L = criteria.list();
			commit();
			if(L != null && L.size() > 0)
				return L.get(0);
			else return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			flush();
			close();
		}
	}
}
