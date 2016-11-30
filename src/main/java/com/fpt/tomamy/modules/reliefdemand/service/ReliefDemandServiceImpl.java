package com.fpt.tomamy.modules.reliefdemand.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.regionmanagement.model.Commune;
import com.fpt.tomamy.modules.regionmanagement.service.CommuneService;
import com.fpt.tomamy.modules.reliefdemand.dao.ReliefDemandDAO;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;

@Service("ReliefDemand")
public class ReliefDemandServiceImpl implements ReliefDemandService{
	@Autowired
	ReliefDemandDAO reliefDemandDAO;
	@Autowired
	CommuneService communeService;
	
	public List<ReliefDemand> list(){
		return reliefDemandDAO.list();
	}
	
	public List<ReliefDemandDetail> list(String reliefSessionCode){
		List<ReliefDemand> list= list();
		List<Commune> lstCommunes = communeService.list();
		HashMap<String, Commune> mCode2Commune = new HashMap<String, Commune>();
		for(Commune c: lstCommunes){
			mCode2Commune.put(c.getCOM_Code(), c);
		}
		
		List<ReliefDemandDetail> lstReliefDemandDetail = new ArrayList<ReliefDemandDetail>();
		for(ReliefDemand rd: list){
			ReliefDemandDetail rdd = new ReliefDemandDetail();
			rdd.setRLFDM_CommuneName(mCode2Commune.get(rd.getRLFDM_CommuneCode()).getCOM_Name());
			rdd.setRLFDM_ReliefSessionCode(rd.getRLFDM_ReliefSessionCode());
			rdd.setRLFDM_CommuneLatLng(mCode2Commune.get(rd.getRLFDM_CommuneCode()).getCOM_LatLng());
			lstReliefDemandDetail.add(rdd);
		}
		return lstReliefDemandDetail;
	}
}
