package com.fpt.tomamy.modules.reliefdemand.model;

public class ReliefDemandDetail extends ReliefDemand{
	String RLFDM_CommuneName;
	String RLFDM_CommuneLatLng;
	String RLFDM_ReliefSessionName;
	public String getRLFDM_CommuneName() {
		return RLFDM_CommuneName;
	}
	public void setRLFDM_CommuneName(String rLFDM_CommuneName) {
		RLFDM_CommuneName = rLFDM_CommuneName;
	}
	public String getRLFDM_ReliefSessionName() {
		return RLFDM_ReliefSessionName;
	}
	public void setRLFDM_ReliefSessionName(String rLFDM_ReliefSessionName) {
		RLFDM_ReliefSessionName = rLFDM_ReliefSessionName;
	}
	public String getRLFDM_CommuneLatLng() {
		return RLFDM_CommuneLatLng;
	}
	public void setRLFDM_CommuneLatLng(String rLFDM_CommuneLatLng) {
		RLFDM_CommuneLatLng = rLFDM_CommuneLatLng;
	}
	
}
