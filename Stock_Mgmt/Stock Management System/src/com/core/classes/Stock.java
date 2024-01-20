package com.core.classes;

import java.time.LocalDate;

public class Stock {
	private String stockId;
	private String stockName;
	private String companyName;
	private double price;
	private LocalDate closingDate;
	private int quantity;
	public Stock(String stockId, String stockName, String companyName, double price, LocalDate closingDate,int quantity) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.companyName = companyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", companyName=" + companyName + ", price="
				+ price + ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
	}
	public String getStockId() {
		return stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public double getPrice() {
		return price;
	}
	public LocalDate getClosingDate() {
		return closingDate;
	}
	public int getQuantity() {
		return quantity;
	}

}
