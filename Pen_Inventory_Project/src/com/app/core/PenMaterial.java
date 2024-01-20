package com.app.core;

public enum PenMaterial {
PLASTIC(5),METAL(10),ALLOY_STEEL(20),OTHER(2);
	
private int amt;

private PenMaterial(int amt) {
	this.amt = amt;
}

public double getAmount() {
	return amt;
}
}
