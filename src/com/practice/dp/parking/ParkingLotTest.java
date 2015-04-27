package com.practice.dp.parking;

public class ParkingLotTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vehicle v1 = new MotorCycle();

		Vehicle v2= new Car();

		Vehicle v3 = new Truck();
		
		ParkingLot lot = new ParkingLot();
		lot.getParkingSlot();
		
	}

}
