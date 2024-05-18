package com.pvz;

import com.pvz.plants.Lilypad;
import com.pvz.plants.Plant;

public class Pool extends Tile {
    private boolean hasLilypad;
    public Pool(){
        super.setType("Pool");
        hasLilypad=false;
    }
    public boolean hasLilypad(){
        return hasLilypad;
    }
    public void combinePlant(Plant plant){
        if (hasLilypad()){
            plant.setHealth(plant.getHealth()+100);
        }
    }
    public boolean isPlantValid(Plant plant){
        if((plant instanceof Lilypad && !hasLilypad) || plant.isAquatic() && hasLilypad()) return true;
        return false;
    }
    
}
