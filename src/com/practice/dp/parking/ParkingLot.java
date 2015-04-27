package com.practice.dp.parking;

import java.util.*;

public class ParkingLot {
	List<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>();

	public void addParkingSlot(ParkingSlot parkingSlot) {
		parkingSlots.add(parkingSlot);
	}
	
	public ParkingSlot getParkingSlot() {
		return parkingSlots.get(0);
	}
}
