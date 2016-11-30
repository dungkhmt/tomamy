package com.fpt.tomamy.modules.relief.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblrelief")
public class Relief {
	@Id
	@GeneratedValue
	int RLF_ID;
	String RLF_Code;
	String RLF_ReliefOrganizationCode;
	String RLF_CommuneCode;
	String RLF_ReliefSessionCode;
	String RLF_CreateByUserCode;
	String RLF_LastModifiedDate;
	public int getRLF_ID() {
		return RLF_ID;
	}
	public void setRLF_ID(int rLF_ID) {
		RLF_ID = rLF_ID;
	}
	public String getRLF_Code() {
		return RLF_Code;
	}
	public void setRLF_Code(String rLF_Code) {
		RLF_Code = rLF_Code;
	}
	public String getRLF_ReliefOrganizationCode() {
		return RLF_ReliefOrganizationCode;
	}
	public void setRLF_ReliefOrganizationCode(String rLF_ReliefOrganizationCode) {
		RLF_ReliefOrganizationCode = rLF_ReliefOrganizationCode;
	}
	public String getRLF_CommuneCode() {
		return RLF_CommuneCode;
	}
	public void setRLF_CommuneCode(String rLF_CommuneCode) {
		RLF_CommuneCode = rLF_CommuneCode;
	}
	public String getRLF_ReliefSessionCode() {
		return RLF_ReliefSessionCode;
	}
	public void setRLF_ReliefSessionCode(String rLF_ReliefSessionCode) {
		RLF_ReliefSessionCode = rLF_ReliefSessionCode;
	}
	public String getRLF_CreateByUserCode() {
		return RLF_CreateByUserCode;
	}
	public void setRLF_CreateByUserCode(String rLF_CreateByUserCode) {
		RLF_CreateByUserCode = rLF_CreateByUserCode;
	}
	public String getRLF_LastModifiedDate() {
		return RLF_LastModifiedDate;
	}
	public void setRLF_LastModifiedDate(String rLF_LastModifiedDate) {
		RLF_LastModifiedDate = rLF_LastModifiedDate;
	}
	
}
