package com.practice.dp.elevatorThread.EventBarrier;

public class EventBarrier extends AbstractEventBarrier {

    private int waiters;
    private boolean eventInProgress;

    public EventBarrier(){
        this.waiters = 0;
        this.eventInProgress = false;
    }

    public synchronized void arrive(){
        this.waiters++;
        if (this.eventInProgress) {
            return;
        }
        while(!this.eventInProgress){
            try {
                if (this.waiters == 1){
                    System.out.println(this.waiters + " minstrel waiting...");
                } else {
                    System.out.println(this.waiters + " minstrels waiting...");
                }
                wait();
            } catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        }
    }

    public synchronized void raise(){
        if (this.eventInProgress){
            return;
        }
        System.out.println("Gatekeeper has lowered the bridge.");
        this.eventInProgress = true;
        notifyAll();
        while(this.waiters != 0){
            try {
                System.out.println("Gatekeeper is waiting for minstrels to cross bridge.");
                wait();
            } catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        }
        this.eventInProgress = false;
        System.out.println("Gatekeeper has raised the bridge.");
    }

    public synchronized void complete(){
        this.waiters--;
        if (this.waiters == 0){
            System.out.println("There are no more minstrels waiting to cross the bridge...");
            notify();
        } else if(this.waiters == 1){
            System.out.println(this.waiters + " minstrel left is waiting to cross the bridge...");
        } else {
            System.out.println(this.waiters + " minstrels left are waiting to cross the bridge...");
        }
    }

    public int waiters(){
        return this.waiters;
    }

}
