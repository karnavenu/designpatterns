package com.practice.dp.elevatorThread.Elevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Launching Elevator");
        System.out.println();

        int numFloors = 0;
        int numElevators = 0;
        int numRiders = 0;
        int elevatorCapacity = 0;
        List<Rider> riderList = new ArrayList<Rider>();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter integer for number of floors in building: ");
        try {
            numFloors = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException e){
            System.err.println("Invalid number format!");
        }
        System.out.print("Enter integer for number of elevators in building: ");
        try {
            numElevators = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException e){
            System.err.println("Invalid number format!");
        }
        System.out.print("Enter integer for number of riders in building: ");
        try {
            numRiders = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException e){
            System.err.println("Invalid number format!");
        }
        System.out.print("Enter integer for number of riders elevator can fit: ");
        try {
            elevatorCapacity = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException e){
            System.err.println("Invalid number format!");
        }

        bufferedReader.close();

        System.out.println();
        System.out.println("Your inputs");
        System.out.println("-----------");
        System.out.println("Number of floors in building: "  + numFloors);
        System.out.println("Number of elevators: " + numElevators);
        System.out.println("Number of riders: " + numRiders);
        System.out.println("Max number of riders in elevator: " + elevatorCapacity);

       	File log = new File("elevator.log");
        System.setOut(new PrintStream(new FileOutputStream(log)));

        Building building = new Building(numFloors, elevatorCapacity, numElevators);

        Random startFloor = new Random();
        Random stopFloor = new Random();
        for (int i = 0; i < numRiders; i++){
            Rider rider = new Rider(i, building, startFloor.nextInt(numFloors), stopFloor.nextInt(numFloors));
            riderList.add(rider);
        }

        //Start rider threads
        for (Rider rider : riderList){
            rider.getThread().start();
        }

        //Start elevators
        for (Elevator elevator : building.getElevators()){
            elevator.getThread().start();
        }

        //Wait for rider threads to terminate
        for (Rider rider : riderList){
            rider.getThread().join();
        }

        //Stop elevators
        for (Elevator elevator : building.getElevators()){
            elevator.getThread().interrupt();
        }

    }
}
