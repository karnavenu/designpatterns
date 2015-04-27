package com.practice.dp.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// DrinkMaker maker = new DrinkMaker();
		// IDrinkBuilder builder = new CoffeeBuilder();
		// maker.makeDrink(builder);
		List<String> drinkList = new ArrayList<String>();
		drinkList.add("Coffee");
		drinkList.add("Tea");
		// String str = "Coffee";
		VendingMachineState state = null;

		for (String str : drinkList) {
			if (str.equals("Coffee")) {
				state = new CoffeeState();
			} else if (str.equals("Tea")) {
				state = new TeaState();
			}

			VendingMachineContext context = new VendingMachineContext(state);
			Drink drink = context.getDrink();
			drink.getDrinkName();
		}

	}

}
