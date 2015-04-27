package com.practice.dp.elevatorThread.Elevator;

public class Rider implements Runnable {

    private int riderId;
    private Building building;
    private int startFloor;
    private int stopFloor;
    private Thread thread;

    public Rider(int riderId, Building building, int startFloor, int stopFloor){
        this.riderId = riderId;
        this.building = building;
        this.startFloor = startFloor;
        this.stopFloor = stopFloor;
        this.thread = new Thread(this, ""+this.riderId);
    }

    public Thread getThread(){
        return this.thread;
    }

    public void run(){
        Elevator elevator;
        while(true){
            if(startFloor < stopFloor){
                System.out.println("Rider " + this.riderId + " wants to go up from floor " + startFloor);
                elevator = building.callUp(startFloor, riderId);
            } else {
                System.out.println("Rider " + this.riderId + " wants to go down from floor " + startFloor);
                elevator = building.callDown(startFloor, riderId);
            }
            System.out.println("Rider " + this.riderId + " is about to enter elevator " + elevator.getElevatorId());

            if (elevator.enter(this.riderId)){
                System.out.println("Rider " + this.riderId + " has entered elevator " + elevator.getElevatorId());
                break;
            }
        }

        System.out.println("Rider " + this.riderId + " on elevator " + elevator.getElevatorId()+ " wants to go to floor " + stopFloor);
        elevator.requestFloor(stopFloor, this.riderId);

        System.out.println("Rider " + this.riderId + " exits elevator " + elevator.getElevatorId() + " on floor " + stopFloor);
        elevator.exit(this.riderId);

    }
}
