package com.fpt.tomamy.modules.reliefdemand.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fpt.tomamy.dao.BaseDao;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;

@Repository("ReliefDemandDAO")
@SuppressWarnings({"unchecked", "rawtypes"})
public class ReliefDemandDAOImpl extends BaseDao implements ReliefDemandDAO{
	
	public void updateAReliefDemand(ReliefDemand rd){
		try{
			begin();
			getSession().update(rd);
			commit();
		}catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			flush();
			close();
		}
	}
	public ReliefDemand getReliefDemand(String reliefSessionCode, String communeCode){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(ReliefDemand.class);
			criteria.add(Restrictions.eq("RLFDM_ReliefSessionCode", reliefSessionCode));
			criteria.add(Restrictions.eq("RLFDM_CommuneCode", communeCode));
			List<ReliefDemand> L = criteria.list();
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
	public int saveAReliefDemand(ReliefDemand rd){
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
	public int saveAReliefDemandDetail(ReliefDemandDetail rdd){
		try{
			begin();
			int id = (int)getSession().save(rdd);
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
	public List<ReliefDemandDetail> listReliefDemandDetail(String reliefDemandCode){
		try{
			begin();
			Criteria criteria = getSession().createCriteria(ReliefDemandDetail.class);
			criteria.add(Restrictions.eq("RLFDMDT_ReliefDemandCode",reliefDemandCode));
			List<ReliefDemandDetail> listReliefDemands = criteria.list();
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
