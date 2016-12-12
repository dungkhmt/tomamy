package com.fpt.tomamy.modules.goods.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblgoods")
public class Good {
	@Id
	@GeneratedValue
	int GOD_ID;
	String GOD_Code;
	String GOD_Name;
	String GOD_Unit;
	public int getGOD_ID() {
		return GOD_ID;
	}
	public void setGOD_ID(int gOD_ID) {
		GOD_ID = gOD_ID;
	}
	public String getGOD_Code() {
		return GOD_Code;
	}
	public void setGOD_Code(String gOD_Code) {
		GOD_Code = gOD_Code;
	}
	public String getGOD_Name() {
		return GOD_Name;
	}
	public void setGOD_Name(String gOD_Name) {
		GOD_Name = gOD_Name;
	}
	public String getGOD_Unit() {
		return GOD_Unit;
	}
	public void setGOD_Unit(String gOD_Unit) {
		GOD_Unit = gOD_Unit;
	}
	
	
}
