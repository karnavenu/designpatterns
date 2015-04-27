package com.practice.dp.elevatorThread.EventBarrier;

public class GateKeeper implements Runnable {

    private String name;
    private EventBarrier eventBarrier;
    private Thread thread;

    public GateKeeper(EventBarrier eventBarrier, String name){
        this.name = name;
        this.eventBarrier = eventBarrier;
        this.thread = new Thread(this, this.name);
    }

    public Thread getThread(){
        return this.thread;
    }

    public void run() {
        eventBarrier.raise();
    }
}
