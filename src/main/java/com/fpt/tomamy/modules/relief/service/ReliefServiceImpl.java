package com.fpt.tomamy.modules.relief.service;

import com.fpt.tomamy.modules.goods.model.Good;
import com.fpt.tomamy.modules.goods.service.GoodService;
import com.fpt.tomamy.modules.relief.dao.ReliefDAO;
import com.fpt.tomamy.modules.relief.model.Relief;
import com.fpt.tomamy.modules.relief.model.ReliefDetail;
import com.fpt.tomamy.modules.relief.model.ReliefDetailFullInfo;
import com.fpt.tomamy.modules.relieforganization.model.ReliefOrganization;
import com.fpt.tomamy.modules.relieforganization.service.ReliefOrganizationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.formula.functions.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Relief")
public class ReliefServiceImpl implements ReliefService{
	@Autowired
	ReliefDAO reliefDAO;
	@Autowired
	GoodService goodService;
	@Autowired
	ReliefOrganizationService reliefOrganizationService;
	
	
	public String name(){
		return "ReliefServiceImpl";
	}
	public List<ReliefDetailFullInfo> getReliefDetailForACommuneInOneReliefSession(String reliefSessionCode, String communeCode){
		List<ReliefDetailFullInfo> rdf = new ArrayList<ReliefDetailFullInfo>();
		List<Relief> reliefs = reliefDAO.getReliefOfASession(reliefSessionCode);
		List<Good> goods = goodService.list();
		List<ReliefOrganization> reliefOrg = reliefOrganizationService.list();
		HashMap<String, Good> mCode2Good = new HashMap<String, Good>();
		HashMap<String , ReliefOrganization> mCode2ReliefOrganization = new HashMap<String, ReliefOrganization>();
		HashMap<String, String> mReliefCode2ReliefOrganizationCode = new HashMap<String, String>();
		
		
		for(Good g: goods) mCode2Good.put(g.getGOD_Code(), g);
		for(ReliefOrganization ro: reliefOrg) mCode2ReliefOrganization.put(ro.getRLFORG_Code(),ro);
		
		ArrayList<String> codes = new ArrayList<String>();
		for(Relief rl: reliefs){
			if(rl.getRLF_CommuneCode().equals(communeCode))
				codes.add(rl.getRLF_Code());
			mReliefCode2ReliefOrganizationCode.put(rl.getRLF_Code(), rl.getRLF_ReliefOrganizationCode());
		}
		
		System.out.println(name() + "::getReliefDetailForACommuneInOneReliefSession, reliefSession = " + reliefSessionCode + 
				", commune = " + communeCode);
		
		List<ReliefDetail> reliefDetails = reliefDAO.getReliefDetail(codes);
		
		if(reliefDetails != null) for(ReliefDetail rd: reliefDetails){
			String reliefOrgCode = mReliefCode2ReliefOrganizationCode.get(rd.getRLFDT_ReliefCode());
			Good g = mCode2Good.get(rd.getRLFDT_GoodCode());
			ReliefDetailFullInfo r = new ReliefDetailFullInfo();
			
			
			r.setGoodName(g.getGOD_Name());
			r.setMoney(rd.getRLFDT_Money());
			r.setQuantity(rd.getRLFDT_Quantity());
			r.setReliefOrganizationName(mCode2ReliefOrganization.get(reliefOrgCode).getRLFORG_Name());
			r.setUnit(g.getGOD_Unit());
			rdf.add(r);
		}
		return rdf;
	}
	public List<Relief> getRelief(String reliefSessionCode){
		return reliefDAO.getReliefOfASession(reliefSessionCode);
	}
	public List<ReliefDetail> getReliefDetail(String reliefSessionCode){
		List<Relief> reliefs = reliefDAO.getReliefOfASession(reliefSessionCode);
		ArrayList<String> codes = new ArrayList<String>();
		for(Relief rl: reliefs)
			codes.add(rl.getRLF_Code());
			
		List<ReliefDetail> LD = reliefDAO.getReliefDetail(codes);
		
		return LD;
	}
	
	public List<Relief> list(){
		return reliefDAO.list();
	}

	public Relief getRelief(String reliefSessionCode, String reliefOrganizationCode, String communeCode){
		return reliefDAO.getRelief(reliefSessionCode, reliefOrganizationCode, communeCode);
	}
	
	public int saveARelief(String reliefSessionCode, String reliefOrganizationCode, String communeCode, String userCode){
		Relief rl = new Relief();
		rl.setRLF_Code(reliefSessionCode + reliefOrganizationCode + communeCode);
		rl.setRLF_CommuneCode(communeCode);
		rl.setRLF_ReliefOrganizationCode(reliefOrganizationCode);
		rl.setRLF_ReliefSessionCode(reliefSessionCode);
		rl.setRLF_CreateByUserCode(userCode);
		return reliefDAO.saveARelief(rl);
	}
	
	public int saveAReliefDetail(String reliefCode, String goodCode, String date, double quantity, int money, String userCode){
		ReliefDetail rd = new ReliefDetail();
		rd.setRLFDT_ReliefCode(reliefCode);
		rd.setRLFDT_GoodCode(goodCode);
		rd.setRLFDT_Quantity(quantity);
		rd.setRLFDT_Money(money);
		rd.setRLFDT_CreatedByUserCode(userCode);
		rd.setRLFDT_Date(date);
		return reliefDAO.saveAReliefDetail(rd);
	}
	
	@Override
	public List<Relief> list(String reliefOrganizationCode) {
		return reliefDAO.getReliefOfAOrganization(reliefOrganizationCode);
	}
}
