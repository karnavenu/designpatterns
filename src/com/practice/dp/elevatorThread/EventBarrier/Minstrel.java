package com.practice.dp.elevatorThread.EventBarrier;

public class Minstrel implements Runnable {

    private String name;
    private EventBarrier eventBarrier;
    private Thread thread;

    public Minstrel(EventBarrier eventBarrier, String name){
        this.name = name;
        this.eventBarrier = eventBarrier;
        this.thread = new Thread(this, this.name);
    }

    public Thread getThread(){
        return this.thread;
    }

    public void run(){
        eventBarrier.arrive();
        try {
            long randomTime = (long) (Math.random() * 10000);
            System.out.println(this.thread.getName() + " sleeping for " + randomTime + " ms");
            Thread.sleep(randomTime);
        } catch (InterruptedException e){
            System.out.println(this.thread.getName() + "interrupted.");
        }
        eventBarrier.complete();
    }

}
