package com.practice.dp.elevatorThread.Elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building {
    private int numFloors;
    private int elevatorCapacity;
    private int numElevators;
//    private Elevator elevator;

    private List<Elevator> elevators;
    private Elevator[] goingUpStops; //array to keep track of elevators going up
    private Elevator[] goingDownStops; //array to keep track of elevators going down

    /**
     * Constructor to instantiate building object
     *
     * @param numFloors number of floors in the building
     * @param elevatorCapacity max number of riders each elevator in building can hold
     * @param numElevators number of elevators in the building
     */
    public Building(int numFloors, int elevatorCapacity, int numElevators){
        this.numFloors = numFloors;
        this.elevatorCapacity = elevatorCapacity;
//        this.elevator = new Elevator(1, this.numFloors, this.elevatorCapacity, this);
        this.elevators = new ArrayList<Elevator>();

        for (int i = 0; i < numElevators; i++){
            elevators.add(new Elevator(i, this.numFloors, this.elevatorCapacity, this));
        }

        this.goingUpStops = new Elevator[this.numFloors];
        this.goingDownStops = new Elevator[this.numFloors];
    }

    public List<Elevator> getElevators(){
        return this.elevators;
    }

    /**
     * Records stop that elevator is requested to go to by rider
     *
     * @param requestedFloor
     * @param isGoingUp
     * @param elevator
     */
    public synchronized void addStop(int requestedFloor, boolean isGoingUp, Elevator elevator){
        if(isGoingUp){
            this.goingUpStops[requestedFloor] = elevator;
        } else {
            this.goingDownStops[requestedFloor] = elevator;
        }
    }

    /**
     * Removes stop once elevator reaches rider's intended destination
     *
     * @param arrivedFloor
     * @param isGoingUp
     */
    public synchronized void removeStop(int arrivedFloor, boolean isGoingUp){
        if(isGoingUp){
            this.goingUpStops[arrivedFloor] = null;
        } else {
            this.goingDownStops[arrivedFloor] = null;
        }
    }

    /**
     * Find the appropriate elevator to fulfill rider request
     *
     * @param floor
     * @param isGoingUp
     * @return
     */
    public synchronized Elevator find(int floor, boolean isGoingUp){
        Elevator elevator;
        boolean hasElevatorGoingUpToFloor = this.goingUpStops[floor] != null;
        boolean hasElevatorGoingDownToFloor = this.goingDownStops[floor] != null;
        if (isGoingUp && hasElevatorGoingUpToFloor){
            elevator = this.goingUpStops[floor];
            return elevator;
        } else if (!isGoingUp && hasElevatorGoingDownToFloor){
            elevator = this.goingDownStops[floor];
            return elevator;
        } else {
            Random random = new Random();
            int randomElevatorIndex = random.nextInt(this.elevators.size());
            elevator = elevators.get(randomElevatorIndex);
            this.addStop(floor, isGoingUp, elevator);
            return elevator;
        }
    }

    /**
     * Signal appropriate elevator
     *
     * @param fromFloor
     * @param isGoingUp
     * @param riderId
     * @return
     */
    private Elevator call(int fromFloor, boolean isGoingUp, int riderId){
        Elevator elevator = find(fromFloor, isGoingUp);
        synchronized (this){
            while(elevator.reachedFullCapacity()){
                try {
                    System.out.println("Elevator " + elevator.getElevatorId() + " has reached full capacity.");
                    wait();
                } catch (InterruptedException e){

                }
            }
        }
        if (isGoingUp){
            System.out.println("Elevator " + elevator.getElevatorId() +  " called by rider " + riderId + " on floor " + fromFloor +" to go up");
        } else {
            System.out.println("Elevator " + elevator.getElevatorId() +  " called by rider " + riderId + " on floor " + fromFloor +" to go down");
        }
        elevator.requestFloor(fromFloor, isGoingUp, riderId);
        while(elevator.isGoingUp() != isGoingUp){
            elevator.pass();
            synchronized (this){
                while(elevator.isDoorOpen()){
                    try {
                        System.out.println("Elevator" + elevator.getElevatorId() + " is not going in the requested direction.");
                        wait();
                    } catch (InterruptedException e){

                    }
                }
            }
            elevator.requestFloor(fromFloor, isGoingUp, riderId);
        }
        return elevator;
    }

    /**
     * Signal an elevator that we want to go up
     *
     * @param fromFloor  floor from which elevator is called
     * @return           instance of the elevator to use to go up
     */
    public Elevator callUp(int fromFloor, int riderId){
        return call(fromFloor, true, riderId);
    }

    /**
     * Signal an elevator that we want to go down
     *
     * @param fromFloor  floor from which elevator is called
     * @param riderId    id of the rider
     * @return           instance of the elevator to use to go down
     */
    public Elevator callDown(int fromFloor, int riderId){
        return call(fromFloor, false, riderId);
    }


    /**
     * Signal an elevator
     *
     * @param fromFloor floor from which elevator is called
     * @param goingUp signals elevator to go up or down
     * @param riderId id of rider
     * @return        instance of the elevator to use to go either up or down
     */
//    private Elevator call(int fromFloor, boolean goingUp, int riderId){
//        synchronized (this){
//            while(this.elevator.reachedFullCapacity()){
//                try {
//                    System.out.println("Elevator has reached full elevatorCapacity.");
//                    wait();
//                } catch (InterruptedException e){
//
//                }
//            }
//        }
//        if (goingUp){
//            System.out.println("Elevator " + this.elevator.getElevatorId() +  " called by rider " + riderId + " on floor " + fromFloor +" to go up");
//        } else {
//            System.out.println("Elevator " + this.elevator.getElevatorId() +  " called by rider " + riderId + " on floor " + fromFloor +" to go down");
//        }
//        this.elevator.requestFloor(fromFloor, goingUp, riderId);
//        while(this.elevator.isGoingUp() != goingUp){
//            this.elevator.pass();
//            synchronized (this){
//                while(this.elevator.isDoorOpen()){
//                    try {
//                        System.out.println("Elevator is not going in the requested direction.");
//                        wait();
//                    } catch (InterruptedException e){
//
//                    }
//                }
//            }
//            this.elevator.requestFloor(fromFloor, goingUp, riderId);
//        }
//
//        return this.elevator;
//    }



}
