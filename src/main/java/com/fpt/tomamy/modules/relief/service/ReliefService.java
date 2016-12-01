package com.fpt.tomamy.modules.relief.service;
import java.util.List;

import com.fpt.tomamy.modules.relief.model.Relief;
public interface ReliefService {
	public List<Relief> list();
	public Relief getRelief(String reliefSessionCode, String reliefOrganizationCode, String communeCode);
	public int saveARelief(String reliefSessionCode, String reliefOrganizationCode, String communeCode, String userCode);
	public int saveAReliefDetail(String reliefCode, String goodCode, String date, double quantity, int money, String userCode);
}
