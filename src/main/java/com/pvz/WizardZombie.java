package com.pvz;

public class WizardZombie extends Zombie {
    private boolean alreadyChanged;
    public WizardZombie()
    {
        super("Wizard Zombie",150,100,1,false,5);
        alreadyChanged=false;
    }

    public void changePlant(Plant plant)
    {
        
    }

    public boolean hasAlreadyChanged() {
        return alreadyChanged;
    }
}
