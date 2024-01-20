package com.app.core;

import java.time.LocalDate;

public class Pen {
	private int id;
	private String brand;
	private String inkColor;
	private PenMaterial material;
	private int stock;
	private LocalDate stockUpdateDate;
	private LocalDate stockListingDate;
	private double price;
	private double discount;
	private static int idGenerator;
	
	public Pen(String brand, String inkColor, PenMaterial material, int stock, double price,LocalDate listingDate) {
		super();
		this.id = ++idGenerator;
		this.brand = brand;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.stockListingDate = listingDate;
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}

	public void setStockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getInkColor() {
		return inkColor;
	}

	public PenMaterial getMaterial() {
		return material;
	}

	public LocalDate getStockListingDate() {
		return stockListingDate;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", inkColor=" + inkColor + ", material=" + material + ", stock="
				+ stock + ", stockUpdateDate=" + stockUpdateDate + ", stockListingDate=" + stockListingDate + ", price="
				+ price + ", discount=" + discount + "]";
	}
	
}
