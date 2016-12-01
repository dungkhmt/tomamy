package com.fpt.tomamy.modules.relief.service;

import com.fpt.tomamy.modules.relief.dao.ReliefDAO;
import com.fpt.tomamy.modules.relief.model.Relief;
import com.fpt.tomamy.modules.relief.model.ReliefDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Relief")
public class ReliefServiceImpl implements ReliefService{
	@Autowired
	ReliefDAO reliefDAO;
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
}
