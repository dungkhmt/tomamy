package com.fpt.tomamy.modules.reliefdemand.dao;

import java.util.List;

import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;

public interface ReliefDemandDAO {
	public List<ReliefDemand> list();
	public List<ReliefDemand> getReliefDemandOfSession(String reliefSessionCode);
	
	public List<ReliefDemandDetail> listReliefDemandDetail(String reliefDemandCode);
	
	public ReliefDemandDetail getReliefDemandDetail(String reliefDemandCode, String goodCode);
	
	public ReliefDemand getReliefDemand(String reliefSessionCode, String communeCode);
	
	public int saveAReliefDemand(ReliefDemand rd);
	public int saveAReliefDemandDetail(ReliefDemandDetail rdd);
	
	public void updateAReliefDemand(ReliefDemand rd);
	public void updateAReliefDemandDetail(ReliefDemandDetail rdd);
}
