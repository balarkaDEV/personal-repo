package com.brahma.order.service.util;

public enum OrderStatus {
	RECEIVED(1),PARTIALLYRECEIVED(2),FAILED(3),SUCCESS(4),FULLFILLED(5);

	private int statusValue;
	
	OrderStatus(int statusValue) {
		this.statusValue = statusValue;
	}
	
	public int getValue() {
		return statusValue;
	}
}
