package com.practice.dp.vendingmachine;

public class TeaState implements VendingMachineState{
	
	@Override
	public Drink collectProduct() {

		System.out.println("TeaState: CollectProduct -- Start");
		DrinkMaker maker = new DrinkMaker();
		IDrinkBuilder builder = new TeaBuilder();
		maker.makeDrink(builder);
		System.out.println("TeaState: CollectProduct -- End--retruning product");
		return maker.getDrink(builder);
	}

}
