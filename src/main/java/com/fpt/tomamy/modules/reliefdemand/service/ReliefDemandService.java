package com.fpt.tomamy.modules.reliefdemand.service;

import java.util.List;

import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;

public interface ReliefDemandService {
	public List<ReliefDemand> list();
	public List<ReliefDemandDetail> list(String reliefSessionCode);
}
