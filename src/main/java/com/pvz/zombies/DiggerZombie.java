package com.pvz.zombies;

import com.pvz.Map;

public class DiggerZombie extends Zombie {
    public boolean alreadySkipped;
    
    public DiggerZombie()
    {
        super("Digger Zombie", "DZ", 175, 100, 1, false, 5);
        alreadySkipped=false;
    }

    public void skill(Map map, int row, int col, Zombie zombie)
    {
        alreadySkipped=true;
        map.getTile(row, col).getListZombie().remove(zombie);
        map.getTile(row, col).addZombie(zombie);
    }
    public boolean isAlreadySkipped() {
        return alreadySkipped;
    }

    public void setAlreadySkipped(boolean alreadySkipped) {
        this.alreadySkipped = alreadySkipped;
    }
    
}
