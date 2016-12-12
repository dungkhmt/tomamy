package com.fpt.tomamy.modules.reliefsession.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblreliefsessions")
public class ReliefSession {
	@Id
	@GeneratedValue
	int RLFSS_ID;
	String RLFSS_Code;
	String RLFSS_Name;
	String RLFSS_StartDate;
	String 	RLFSS_EndDate;
	String RLFSS_CreatedByUserCode;
	String RLFSS_LastModifiedDate;
	public int getRLFSS_ID() {
		return RLFSS_ID;
	}
	public void setRLFSS_ID(int rLFSS_ID) {
		RLFSS_ID = rLFSS_ID;
	}
	public String getRLFSS_Code() {
		return RLFSS_Code;
	}
	public void setRLFSS_Code(String rLFSS_Code) {
		RLFSS_Code = rLFSS_Code;
	}
	public String getRLFSS_Name() {
		return RLFSS_Name;
	}
	public void setRLFSS_Name(String rLFSS_Name) {
		RLFSS_Name = rLFSS_Name;
	}
	public String getRLFSS_StartDate() {
		return RLFSS_StartDate;
	}
	public void setRLFSS_StartDate(String rLFSS_StartDate) {
		RLFSS_StartDate = rLFSS_StartDate;
	}
	public String getRLFSS_EndDate() {
		return RLFSS_EndDate;
	}
	public void setRLFSS_EndDate(String rLFSS_EndDate) {
		RLFSS_EndDate = rLFSS_EndDate;
	}
	public String getRLFSS_CreatedByUserCode() {
		return RLFSS_CreatedByUserCode;
	}
	public void setRLFSS_CreatedByUserCode(String rLFSS_CreatedByUserCode) {
		RLFSS_CreatedByUserCode = rLFSS_CreatedByUserCode;
	}
	public String getRLFSS_LastModifiedDate() {
		return RLFSS_LastModifiedDate;
	}
	public void setRLFSS_LastModifiedDate(String rLFSS_LastModifiedDate) {
		RLFSS_LastModifiedDate = rLFSS_LastModifiedDate;
	}
	
}
