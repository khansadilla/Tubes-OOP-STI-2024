package com.pvz.plants;

import com.pvz.Point;
import com.pvz.ExceptionHandling.IllegalTypeException;
import com.pvz.Interface.Factory;

public class PlantFactory implements Factory<Plant> {
    @Override
    public Plant create(long timeCreated, String type, Point position) throws IllegalTypeException {
        switch (type) {
            case "Peashooter":
                return new Peashooter(position, timeCreated);            
            // lanjutin 
        
            default:
                break;
        }
        throw new IllegalTypeException("Plant type not found.");
    }
}
