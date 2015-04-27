package com.practice.dp.vendingmachine;

public interface IDrinkBuilder {
	Drink createDrink();
	void addWater();
    void addPowder();
    Drink getDrink();
}
