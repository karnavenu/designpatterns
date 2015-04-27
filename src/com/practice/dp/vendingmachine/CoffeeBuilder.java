package com.practice.dp.vendingmachine;

public class CoffeeBuilder implements IDrinkBuilder {
	Drink drink;
	@Override
	public void addWater() {
		System.out.println("CoffeeBuilder: BuildingWater");
		drink.setWater();		
	}

	@Override
	public void addPowder() {
		System.out.println("CoffeeBuilder: BuildingPowder");
		drink.setPowder();		
	}

	@Override
	public Drink getDrink() {
		return drink;
	}

	@Override
	public Drink createDrink() {
		drink = new Coffee();
		return drink;
		
	}

}
