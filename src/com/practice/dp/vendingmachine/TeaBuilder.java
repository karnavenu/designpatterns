package com.practice.dp.vendingmachine;

public class TeaBuilder implements IDrinkBuilder{

	Drink drink;
	@Override
	public void addWater() {
		drink.setWater();		
	}

	@Override
	public void addPowder() {
		drink.setPowder();		
	}

	@Override
	public Drink getDrink() {
		return drink;
	}

	@Override
	public Drink createDrink() {
		drink = new Tea();
		return drink;
		
	}

}
