package com.app.core;

public enum ServicePlan {
//	ServicePlan : enum
//	ServicePlan charges : 
//	SILVER : 1000 
//	GOLD : 2000
//	DIAMOND : 5000
//	PLATINUM : 10000
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	//Adding parameter ctor to define the charges of each enum 
	private int charges;
	private ServicePlan(int charges) {
		this.charges = charges;
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	
}
