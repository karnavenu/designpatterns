package com.practice.dp.vendingmachine;

public class VendingMachineContext {
	private VendingMachineState state = null;

	public VendingMachineContext(VendingMachineState state) {
		this.state = state;
	}

	public Drink getDrink() {
		return state.collectProduct();
	}
}
