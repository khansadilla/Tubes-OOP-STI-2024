package com.pvz.plants;

import com.pvz.Point;

public class Lilypad extends Plant{
    private boolean isOccupied = false;

    public Lilypad(Point position) {
        super("Lilypad", 25, 100,0, 0, 0, 10, position, true);
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void increasePlantHealth() {

    }
}