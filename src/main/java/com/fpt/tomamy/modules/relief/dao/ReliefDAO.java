package com.fpt.tomamy.modules.relief.dao;
import java.util.List;

import com.fpt.tomamy.modules.relief.model.Relief;
import com.fpt.tomamy.modules.relief.model.ReliefDetail;

public interface ReliefDAO {
	public List<Relief> list();
	public Relief getRelief(String reliefSessionCode, String reliefOrganizationCode, String communeCode);
	public int saveARelief(Relief rl);
	public int saveAReliefDetail(ReliefDetail rd);
	public void updateARelief(Relief rl);
	public void updateAReliefDetail(ReliefDetail rd);
}
