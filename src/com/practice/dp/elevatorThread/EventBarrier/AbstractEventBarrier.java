package com.practice.dp.elevatorThread.EventBarrier;

public abstract class AbstractEventBarrier {

    /**
     * Instantiate the stateless AbstractEventBarrier.
     */
    public AbstractEventBarrier() {
    }

    /**
     * Arrive at the barrier and wait until an event is signaled. Return
     * immediately if already in the signaled state.
     */
    public abstract void arrive();

    /**
     * Signal the event and block until all threads that wait for this
     * event have responded. The EventBarrier returns to an unsignaled state
     * before raise() returns.
     */
    public abstract void raise();

    /**
     * Indicate that the calling thread has finished responding to a
     * signaled event, and block until all other threads that wait for
     * this event have also responded.
     */
    public abstract void complete();

    /**
     * Return a count of threads that are waiting for the event or that
     * have not responded yet.
     */
    public abstract int waiters();
}