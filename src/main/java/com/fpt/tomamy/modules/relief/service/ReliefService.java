package com.fpt.tomamy.modules.relief.service;
import java.util.List;

import com.fpt.tomamy.modules.relief.model.Relief;
import com.fpt.tomamy.modules.relief.model.ReliefDetail;
import com.fpt.tomamy.modules.relief.model.ReliefDetailFullInfo;
public interface ReliefService {
	public List<Relief> list();
	public List<Relief> list(String reliefOrganizationCode);
	public Relief getRelief(String reliefSessionCode, String reliefOrganizationCode, String communeCode);
	public int saveARelief(String reliefSessionCode, String reliefOrganizationCode, String communeCode, String userCode);
	public int saveAReliefDetail(String reliefCode, String goodCode, String date, double quantity, int money, String userCode);
	public List<Relief> getRelief(String reliefSessionCode);
	public List<ReliefDetail> getReliefDetail(String reliefSessionCode);
	public List<ReliefDetailFullInfo> getReliefDetailForACommuneInOneReliefSession(String reliefSessionCode, String communeCode);
	
}
