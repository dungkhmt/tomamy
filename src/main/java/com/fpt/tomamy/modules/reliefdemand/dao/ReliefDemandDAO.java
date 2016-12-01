package com.fpt.tomamy.modules.reliefdemand.dao;

import java.util.List;

import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;

public interface ReliefDemandDAO {
	public List<ReliefDemand> list();
	public List<ReliefDemandDetail> listReliefDemandDetail(String reliefDemandCode);
	
	public ReliefDemand getReliefDemand(String reliefSessionCode, String communeCode);
	
	public int saveAReliefDemand(ReliefDemand rd);
	public int saveAReliefDemandDetail(ReliefDemandDetail rdd);
	
	public void updateAReliefDemand(ReliefDemand rd);
}
