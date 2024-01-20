package com.core.classes;

public class Order {
	private int orderId;
	private int petId;
	private int quantity;
	private Status status;
	private static int idGenerator; 
	
	public Order(int petId, int quantity) {
		super();
		this.orderId=++idGenerator;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.PLACED;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}

	public int getQuantity() {
		return quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}
	
	
}
