package com.pvz.zombies;

import com.pvz.Map;

public class WizardZombie extends Zombie {
    private boolean alreadyChanged;
    
    public WizardZombie()
    {
        super("Wizard Zombie",150,100,1,false,5);
        alreadyChanged=false;
    }
    
    public void skill(Map map, int row, int col, Zombie zombie)
    {
        alreadyChanged=true;
        map.getTile(row, col).addZombie(new NormalZombie());
        map.getTile(row, col).removePlant();
    }
    public boolean isAlreadyChanged() {
        return alreadyChanged;
    }
    
    public void setAlreadyChanged(boolean alreadyChanged) {
        this.alreadyChanged = alreadyChanged;
    }
}
