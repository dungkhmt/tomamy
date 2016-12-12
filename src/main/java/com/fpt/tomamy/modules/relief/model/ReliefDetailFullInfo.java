package com.fpt.tomamy.modules.relief.model;

public class ReliefDetailFullInfo extends ReliefDetail{

	String goodName;
	double quantity;
	String unit;
	int money;
	String reliefOrganizationName;
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getReliefOrganizationName() {
		return reliefOrganizationName;
	}
	public void setReliefOrganizationName(String reliefOrganizationName) {
		this.reliefOrganizationName = reliefOrganizationName;
	}
	
	
}
