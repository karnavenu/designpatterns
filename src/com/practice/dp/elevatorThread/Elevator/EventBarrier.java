package com.practice.dp.elevatorThread.Elevator;

public class EventBarrier {
    private int waiters;
    private boolean eventInProgress;

    public EventBarrier(){
        this.waiters = 0;
        this.eventInProgress = false;
    }

    /**
     * Rider thread signals its arrival (rider thread is waiting for elevator door to open)
     * @param elevatorId
     * @param floor
     * @param riderId
     */
    public synchronized void arrive(int elevatorId, int floor, int riderId){
        this.waiters++;
        if (this.eventInProgress) {
            return;
        }
        while(!this.eventInProgress){
            try {
                if (this.waiters == 1){
                    System.out.println(this.waiters + " rider waiting for elevator " + elevatorId +" on floor " + floor);
                } else {
                    System.out.println(this.waiters + " riders waiting for elevator " + elevatorId +" on floor " + floor);
                }
                super.wait();
            } catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        }
    }

    /**
     * Event barrier raises an event (elevator door opening)
     * @param elevatorId
     * @param floor
     */
    public synchronized void raise(int elevatorId, int floor){
        if (this.eventInProgress){
            return;
        }
        System.out.println("Elevator " + elevatorId + " doors are opened on floor " + floor);
        this.eventInProgress = true;
        notifyAll();
        while(this.waiters != 0){
            try {
                System.out.println("Elevator " + elevatorId +" is waiting for riders to enter door on floor " + floor);
                super.wait();
            } catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        }
        this.eventInProgress = false;
        System.out.println("Elevator " + elevatorId + " is closing door on floor " + floor);
    }

    /**
     * Rider thread signals its exit (rider has exited the elevator)
     * @param elevatorId
     * @param floor
     */
    public synchronized void complete(int elevatorId, int floor){
        this.waiters--;
        if (this.waiters == 0){
            System.out.println("There are no more riders waiting for elevator " + elevatorId + " on floor " + floor);
            notifyAll();
        } else if (this.waiters == 1){
            System.out.println(this.waiters + " rider left waiting to enter elevator " + elevatorId + "on floor " + floor);
        } else {
            System.out.println(this.waiters + " riders left waiting to enter elevator " + elevatorId + "on floor " + floor);
        }

    }

    /**
     * Get total number of riders waiting for elevator door to open
     * @return number of waiting riders
     */
    public int waiters(){
        return this.waiters;
    }
}
