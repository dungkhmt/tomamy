package com.fpt.tomamy.modules.relief.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblreliefdetail")
public class ReliefDetail {
	@Id
	@GeneratedValue
	int RLFDT_ID;
	String RLFDT_Code;
	String RLFDT_ReliefCode;
	String RLFDT_Date;
	String RLFDT_GoodCode;
	double 	RLFDT_Quantity;
	int RLFDT_Money;
	String RLFDT_CreatedByUserCode;
	String 	RLFDT_LastModifiedDate;
	public int getRLFDT_ID() {
		return RLFDT_ID;
	}
	public void setRLFDT_ID(int rLFDT_ID) {
		RLFDT_ID = rLFDT_ID;
	}
	public String getRLFDT_Code() {
		return RLFDT_Code;
	}
	public void setRLFDT_Code(String rLFDT_Code) {
		RLFDT_Code = rLFDT_Code;
	}
	public String getRLFDT_ReliefCode() {
		return RLFDT_ReliefCode;
	}
	public void setRLFDT_ReliefCode(String rLFDT_ReliefCode) {
		RLFDT_ReliefCode = rLFDT_ReliefCode;
	}
	public String getRLFDT_Date() {
		return RLFDT_Date;
	}
	public void setRLFDT_Date(String rLFDT_Date) {
		RLFDT_Date = rLFDT_Date;
	}
	public String getRLFDT_GoodCode() {
		return RLFDT_GoodCode;
	}
	public void setRLFDT_GoodCode(String rLFDT_GoodCode) {
		RLFDT_GoodCode = rLFDT_GoodCode;
	}
	public double getRLFDT_Quantity() {
		return RLFDT_Quantity;
	}
	public void setRLFDT_Quantity(double rLFDT_Quantity) {
		RLFDT_Quantity = rLFDT_Quantity;
	}
	public int getRLFDT_Money() {
		return RLFDT_Money;
	}
	public void setRLFDT_Money(int rLFDT_Money) {
		RLFDT_Money = rLFDT_Money;
	}
	public String getRLFDT_CreatedByUserCode() {
		return RLFDT_CreatedByUserCode;
	}
	public void setRLFDT_CreatedByUserCode(String rLFDT_CreatedByUserCode) {
		RLFDT_CreatedByUserCode = rLFDT_CreatedByUserCode;
	}
	public String getRLFDT_LastModifiedDate() {
		return RLFDT_LastModifiedDate;
	}
	public void setRLFDT_LastModifiedDate(String rLFDT_LastModifiedDate) {
		RLFDT_LastModifiedDate = rLFDT_LastModifiedDate;
	}
	
	
}
