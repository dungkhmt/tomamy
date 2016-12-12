package com.fpt.tomamy.modules.reliefdemand.service;

import java.util.List;

import com.fpt.tomamy.modules.goods.model.Good;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetailFullInfo;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandFullInfo;

public interface ReliefDemandService {
	public List<ReliefDemand> list();
	public List<ReliefDemand> listReliefDemandOfSession(String reliefSessionCode);
	public List<ReliefDemandFullInfo> list(String reliefSessionCode);
	public List<Good> listGoodsDemand(String reliefCommuneSessionCode);
	public List<ReliefDemandDetail> listReliefDemandDetail(String reliefDemandCode);
	public List<ReliefDemandDetailFullInfo> listReliefDemandDetailFullInfo(String reliefDemandCode);
	
	public int saveAReliefDemand(String reliefSessionCode, String communeCode, String userCode);
	public ReliefDemand getReliefDemand(String reliefSessionCode, String communeCode);
	
	public int saveAReliefDemandDetail(String reliefDemandCode, String goodCode, double quantity, String userCode);
	
	
}
