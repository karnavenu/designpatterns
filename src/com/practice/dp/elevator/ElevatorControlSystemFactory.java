package com.practice.dp.elevator;

public interface ElevatorControlSystemFactory {
	public void pickUp(Integer pickUpFloor);

	public void destination(Integer elevatorId, Integer destinationFloor);

	public void step();
}
