package com.fpt.tomamy.modules.reliefdemand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblreliefdemanddetail")
public class ReliefDemandDetail{
	@Id
	@GeneratedValue
	int RLFDMDT_ID;
	String RLFDMDT_Code;
	String RLFDMDT_ReliefDemandCode;
	String RLFDMDT_GoodCode;
	double RLFDMDT_Quantity;
	String RLFDMDT_CreatedByUserCode;
	String RLFDMDT_LastModifiedDate;
	public int getRLFDMDT_ID() {
		return RLFDMDT_ID;
	}
	public void setRLFDMDT_ID(int rLFDMDT_ID) {
		RLFDMDT_ID = rLFDMDT_ID;
	}
	public String getRLFDMDT_Code() {
		return RLFDMDT_Code;
	}
	public void setRLFDMDT_Code(String rLFDMDT_Code) {
		RLFDMDT_Code = rLFDMDT_Code;
	}
	public String getRLFDMDT_ReliefDemandCode() {
		return RLFDMDT_ReliefDemandCode;
	}
	public void setRLFDMDT_ReliefDemandCode(String rLFDMDT_ReliefDemandCode) {
		RLFDMDT_ReliefDemandCode = rLFDMDT_ReliefDemandCode;
	}
	public String getRLFDMDT_GoodCode() {
		return RLFDMDT_GoodCode;
	}
	public void setRLFDMDT_GoodCode(String rLFDMDT_GoodCode) {
		RLFDMDT_GoodCode = rLFDMDT_GoodCode;
	}
	public double getRLFDMDT_Quantity() {
		return RLFDMDT_Quantity;
	}
	public void setRLFDMDT_Quantity(double rLFDMDT_Quantity) {
		RLFDMDT_Quantity = rLFDMDT_Quantity;
	}
	public String getRLFDMDT_CreatedByUserCode() {
		return RLFDMDT_CreatedByUserCode;
	}
	public void setRLFDMDT_CreatedByUserCode(String rLFDMDT_CreatedByUserCode) {
		RLFDMDT_CreatedByUserCode = rLFDMDT_CreatedByUserCode;
	}
	public String getRLFDMDT_LastModifiedDate() {
		return RLFDMDT_LastModifiedDate;
	}
	public void setRLFDMDT_LastModifiedDate(String rLFDMDT_LastModifiedDate) {
		RLFDMDT_LastModifiedDate = rLFDMDT_LastModifiedDate;
	}
	
	
}
