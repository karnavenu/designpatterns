package com.practice.dp.vendingmachine;

public class CoffeeState implements VendingMachineState{
	
	@Override
	public Drink collectProduct() {

		System.out.println("CoffeeState: CollectProduct -- Start");
		DrinkMaker maker = new DrinkMaker();
		IDrinkBuilder builder = new CoffeeBuilder();
		maker.makeDrink(builder);
		System.out.println("CoffeeState: CollectProduct -- End--retruning product");
		return maker.getDrink(builder);
	}

}
