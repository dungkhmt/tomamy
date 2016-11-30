package com.fpt.tomamy.modules.reliefdemand.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="tblreliefdemand")
public class ReliefDemand {
	@Id
	@GeneratedValue
	int RLFDM_ID;
	String RLFDM_Code;
	String RLFDM_CommuneCode;
	String RLFDM_ReliefSessionCode;
	String RLFDM_CreatedByUserCode;
	String RLFDM_LastModifiedDate;
	public int getRLFDM_ID() {
		return RLFDM_ID;
	}
	public void setRLFDM_ID(int rLFDM_ID) {
		RLFDM_ID = rLFDM_ID;
	}
	public String getRLFDM_Code() {
		return RLFDM_Code;
	}
	public void setRLFDM_Code(String rLFDM_Code) {
		RLFDM_Code = rLFDM_Code;
	}
	public String getRLFDM_CommuneCode() {
		return RLFDM_CommuneCode;
	}
	public void setRLFDM_CommuneCode(String rLFDM_CommuneCode) {
		RLFDM_CommuneCode = rLFDM_CommuneCode;
	}
	public String getRLFDM_ReliefSessionCode() {
		return RLFDM_ReliefSessionCode;
	}
	public void setRLFDM_ReliefSessionCode(String rLFDM_ReliefSessionCode) {
		RLFDM_ReliefSessionCode = rLFDM_ReliefSessionCode;
	}
	public String getRLFDM_CreatedByUserCode() {
		return RLFDM_CreatedByUserCode;
	}
	public void setRLFDM_CreatedByUserCode(String rLFDM_CreatedByUserCode) {
		RLFDM_CreatedByUserCode = rLFDM_CreatedByUserCode;
	}
	public String getRLFDM_LastModifiedDate() {
		return RLFDM_LastModifiedDate;
	}
	public void setRLFDM_LastModifiedDate(String rLFDM_LastModifiedDate) {
		RLFDM_LastModifiedDate = rLFDM_LastModifiedDate;
	}
	
}
