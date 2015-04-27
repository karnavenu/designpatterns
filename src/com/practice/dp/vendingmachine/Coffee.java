package com.practice.dp.vendingmachine;

public class Coffee extends Drink {

	@Override
	public void setWater() {
		System.out.println("Coffee: Set Water");
	}

	@Override
	public void setPowder() {
		System.out.println("Coffee: Set Powder");
	}

	@Override
	public void getDrinkName() {
		System.out.println("It's Coffee");		
	}
}
