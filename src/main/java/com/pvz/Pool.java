package com.pvz;

import com.pvz.plants.Lilypad;
import com.pvz.plants.Plant;
import com.pvz.ExceptionHandling.*;

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
        setPlant(plant);
        plant.setHealth(plant.getHealth()+100);
    }
    @Override
    public boolean isPlantValid(Plant plant){
        if((plant instanceof Lilypad && !hasLilypad) || !plant.isAquatic() && hasLilypad()) return true;
        return false;
    }
    @Override
    public void addPlant(Plant plant) throws IllegalPlantingException {
        if(isPlantValid(plant)){
            if(plant instanceof Lilypad){
                hasLilypad=true;
                super.addPlant(plant);
            } else if (hasLilypad() && plant.isAquatic()){
                // super.addPlant(combinePlant(plant));
                combinePlant(plant);
            }
            else{
                throw new IllegalPlantingException("Plant is not valid");
            }
        }
        else{
            throw new IllegalPlantingException("Plant is not valid");
        }
    }
}
