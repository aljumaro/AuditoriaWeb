package com.aljumaro.auditoria;

public class Checkout {

	int total = 0;

	public void add(int nItems, int price) {

		total += nItems * price;

	}

	public int getTotal() {
		return total;
	}

}