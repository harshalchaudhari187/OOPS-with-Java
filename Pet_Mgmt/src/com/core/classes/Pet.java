package com.core.classes;

public class Pet {
	private int petId;
	private String name;
	private Category category;
	private int unitPrice;
	private int stocks;
	
	public Pet(int petId, String name, Category category, int unitPrice, int stocks) {
		super();
		this.petId = petId;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
	}
	
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", unitPrice=" + unitPrice
				+ ", stocks=" + stocks + "]";
	}

	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	public int getPetId() {
		return petId;
	}
	public String getName() {
		return name;
	}
	public Category getCategory() {
		return category;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	
}
