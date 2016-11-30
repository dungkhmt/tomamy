package com.fpt.tomamy.modules.regionmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblcommunes")
public class Commune {
	@Id
	@GeneratedValue
	int COM_ID;
	String COM_Code;
	String COM_Name;
	String COM_LatLng;
	String COM_DistrictCode;
	public int getCOM_ID() {
		return COM_ID;
	}
	public void setCOM_ID(int cOM_ID) {
		COM_ID = cOM_ID;
	}
	public String getCOM_Code() {
		return COM_Code;
	}
	public void setCOM_Code(String cOM_Code) {
		COM_Code = cOM_Code;
	}
	public String getCOM_Name() {
		return COM_Name;
	}
	public void setCOM_Name(String cOM_Name) {
		COM_Name = cOM_Name;
	}
	public String getCOM_LatLng() {
		return COM_LatLng;
	}
	public void setCOM_LatLng(String cOM_LatLng) {
		COM_LatLng = cOM_LatLng;
	}
	public String getCOM_DistrictCode() {
		return COM_DistrictCode;
	}
	public void setCOM_DistrictCode(String cOM_DistrictCode) {
		COM_DistrictCode = cOM_DistrictCode;
	}
	
	
}
