package com.practice.dp.vendingmachine;

public class Tea extends Drink {

	@Override
	public void setWater() {
		System.out.println("Tea: Set Water");		
	}

	@Override
	public void setPowder() {
		System.out.println("Tea: Set Powder");		
	}
	
	@Override
	public void getDrinkName() {
		System.out.println("It's Tea");		
	}
}
