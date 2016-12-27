package com.fpt.tomamy.modules.reliefdemand.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.tomamy.modules.goods.model.Good;
import com.fpt.tomamy.modules.goods.service.GoodService;
import com.fpt.tomamy.modules.regionmanagement.model.Commune;
import com.fpt.tomamy.modules.regionmanagement.service.CommuneService;
import com.fpt.tomamy.modules.reliefdemand.dao.ReliefDemandDAO;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetailFullInfo;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandFullInfo;
import com.mysql.jdbc.log.Log;

@Service("ReliefDemand")
public class ReliefDemandServiceImpl implements ReliefDemandService{
	@Autowired
	ReliefDemandDAO reliefDemandDAO;
	@Autowired
	CommuneService communeService;
	@Autowired
	GoodService goodService;
	
	
	public String name(){
		return "ReliefDemandServiceImpl";
	}
	public int saveAReliefDemandDetail(String reliefDemandCode, String goodCode, double quantity, String userCode){
		ReliefDemandDetail rdd = reliefDemandDAO.getReliefDemandDetail(reliefDemandCode, goodCode);
		if(rdd != null){
			System.out.println(name() + "::saveAReliefDemandDetail, record already exit!!!!!");
			return -1;
		}
		
		rdd = new ReliefDemandDetail();
		
		rdd.setRLFDMDT_GoodCode(goodCode);
		rdd.setRLFDMDT_ReliefDemandCode(reliefDemandCode);
		rdd.setRLFDMDT_Quantity(quantity);
		rdd.setRLFDMDT_CreatedByUserCode(userCode);
		int id = reliefDemandDAO.saveAReliefDemandDetail(rdd);
		System.out.println(name() + "::saveAReliefDemandDetail, id = " + id);
		rdd = reliefDemandDAO.getReliefDemandDetail(reliefDemandCode, goodCode);
		rdd.setRLFDMDT_Code(reliefDemandCode + id);
		reliefDemandDAO.updateAReliefDemandDetail(rdd);
		
		return id;
	}
	public int saveAReliefDemand(String reliefSessionCode, String communeCode, String userCode){
		ReliefDemand rd = new ReliefDemand();
		rd.setRLFDM_Code(reliefSessionCode + communeCode);
		
		rd.setRLFDM_ReliefSessionCode(reliefSessionCode);
		rd.setRLFDM_CommuneCode(communeCode);
		rd.setRLFDM_CreatedByUserCode(userCode);
		int id = reliefDemandDAO.saveAReliefDemand(rd);
		
		
		reliefDemandDAO.updateAReliefDemand(rd);
		
		return id;
	}
	public ReliefDemand getReliefDemand(String reliefSessionCode, String communeCode){
		return reliefDemandDAO.getReliefDemand(reliefSessionCode, communeCode);
	}
	public List<ReliefDemand> list(){
		return reliefDemandDAO.list();
	}
	public List<ReliefDemand> listReliefDemandOfSession(String reliefSessionCode){
		return reliefDemandDAO.getReliefDemandOfSession(reliefSessionCode);
	}
	public List<ReliefDemandFullInfo> list(String reliefSessionCode){
		List<ReliefDemand> list= listReliefDemandOfSession(reliefSessionCode);
		List<Commune> lstCommunes = communeService.list();
		HashMap<String, Commune> mCode2Commune = new HashMap<String, Commune>();
		for(Commune c: lstCommunes){
			mCode2Commune.put(c.getCOM_Code(), c);
		}
		
		List<ReliefDemandFullInfo> lstReliefDemandDetail = new ArrayList<ReliefDemandFullInfo>();
		for(ReliefDemand rd: list){
			ReliefDemandFullInfo rdd = new ReliefDemandFullInfo();
			rdd.setRLFDM_Code(rd.getRLFDM_Code());
			rdd.setRLFDM_CommuneName(mCode2Commune.get(rd.getRLFDM_CommuneCode()).getCOM_Name());
			rdd.setRLFDM_ReliefSessionCode(rd.getRLFDM_ReliefSessionCode());
			rdd.setRLFDM_CommuneLatLng(mCode2Commune.get(rd.getRLFDM_CommuneCode()).getCOM_LatLng());
			lstReliefDemandDetail.add(rdd);
		}
		return lstReliefDemandDetail;
	}
	public List<ReliefDemandDetail> listReliefDemandDetail(String reliefDemandCode){
		return reliefDemandDAO.listReliefDemandDetail(reliefDemandCode);
	}
	public List<ReliefDemandDetailFullInfo> listReliefDemandDetailFullInfo(String reliefDemandCode){
		List<ReliefDemandDetailFullInfo> L = new ArrayList<ReliefDemandDetailFullInfo>();
		List<ReliefDemandDetail> lrdd = listReliefDemandDetail(reliefDemandCode);
		List<Good> G = goodService.list();
		HashMap<String, Good> mCode2Good = new HashMap<String, Good>();
		for(Good g: G)
			mCode2Good.put(g.getGOD_Code(), g);
		
		for(ReliefDemandDetail rdd: lrdd){
			ReliefDemandDetailFullInfo rddi = new ReliefDemandDetailFullInfo();
			Good g = mCode2Good.get(rdd.getRLFDMDT_GoodCode());
			rddi.setRLFDMDT_GoodName(g.getGOD_Name());
			rddi.setRLFDMDT_Quantity(rdd.getRLFDMDT_Quantity());
			rddi.setRLFDMDT_GoodUnit(g.getGOD_Unit());
			L.add(rddi);
		}
		return L;
		
	}
	public List<Good> listGoodsDemand(String reliefDemandCode){
		List<Good> goods = goodService.list();
		HashMap<String, Good>  mCode2Good = new HashMap<String, Good>();
		for(Good g: goods)
			mCode2Good.put(g.getGOD_Code(), g);
		List<ReliefDemandDetail> L = listReliefDemandDetail(reliefDemandCode);
		List<Good> G = new ArrayList<Good>();
		for(ReliefDemandDetail rdd: L){
			Good g = mCode2Good.get(rdd.getRLFDMDT_GoodCode());
			G.add(g);
		}
		
		return G;
	}
}
