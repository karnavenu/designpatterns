package com.practice.dp.vendingmachine;

public class DrinkMaker {
	public void makeDrink(IDrinkBuilder builder) {
		builder.createDrink();
		builder.addWater();
		builder.addPowder();
	}

	public Drink getDrink(IDrinkBuilder builder) {
		return builder.getDrink();
	}
}
