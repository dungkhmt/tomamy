package com.fpt.tomamy.modules.relieforganization.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tblrelieforganization")
public class ReliefOrganization {
	@Id
	@GeneratedValue
	int RLFORG_ID;
	String RLFORG_Code;
	String RLFORG_Name;
	String RLFORG_Phone;
	String RLFORG_CreatedByUserCode;
	String RLFORG_LastModifiedDate;
	public int getRLFORG_ID() {
		return RLFORG_ID;
	}
	public void setRLFORG_ID(int rLFORG_ID) {
		RLFORG_ID = rLFORG_ID;
	}
	public String getRLFORG_Code() {
		return RLFORG_Code;
	}
	public void setRLFORG_Code(String rLFORG_Code) {
		RLFORG_Code = rLFORG_Code;
	}
	public String getRLFORG_Name() {
		return RLFORG_Name;
	}
	public void setRLFORG_Name(String rLFORG_Name) {
		RLFORG_Name = rLFORG_Name;
	}
	public String getRLFORG_Phone() {
		return RLFORG_Phone;
	}
	public void setRLFORG_Phone(String rLFORG_Phone) {
		RLFORG_Phone = rLFORG_Phone;
	}
	public String getRLFORG_CreatedByUserCode() {
		return RLFORG_CreatedByUserCode;
	}
	public void setRLFORG_CreatedByUserCode(String rLFORG_CreatedByUserCode) {
		RLFORG_CreatedByUserCode = rLFORG_CreatedByUserCode;
	}
	public String getRLFORG_LastModifiedDate() {
		return RLFORG_LastModifiedDate;
	}
	public void setRLFORG_LastModifiedDate(String rLFORG_LastModifiedDate) {
		RLFORG_LastModifiedDate = rLFORG_LastModifiedDate;
	}
	
	
}
