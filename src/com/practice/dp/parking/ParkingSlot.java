package com.practice.dp.parking;

public class ParkingSlot {
	Vehicle vehicle = null;
	private ParkingSlotEnum slotType;
	private boolean isEmpty = true;

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public ParkingSlotEnum getSlotType() {
		return slotType;
	}

	public void setSlotType(ParkingSlotEnum slotType) {
		this.slotType = slotType;
	}

	public ParkingSlot() {

	}

	public void vehicleArrived(Vehicle vehicle, ParkingSlotEnum slotType) {
		this.vehicle = vehicle;
		this.slotType = slotType;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void vehicleLeft() {
		this.vehicle = null;
	}
}
