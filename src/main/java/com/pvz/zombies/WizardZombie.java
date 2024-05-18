package com.pvz.zombies;

import com.pvz.plants.Plant;

public class WizardZombie extends Zombie {
    private boolean alreadyChanged;
    public WizardZombie(long timeCreated)
    {
        super("Wizard Zombie",150,100,1,false,5,timeCreated);
        alreadyChanged=false;
    }

    public void changePlant(Plant plant)
    {
        
    }

    public boolean hasAlreadyChanged() {
        return alreadyChanged;
    }
}
