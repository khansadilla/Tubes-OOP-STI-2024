package com.pvz.plants;


public class Lilypad extends Plant{
    private boolean isOccupied = false;

    public Lilypad() {
        super("Lilypad", 25, 100,0, 0, 0, 10, true);
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void increasePlantHealth() {

    }
}