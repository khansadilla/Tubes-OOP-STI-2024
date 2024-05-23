package com.pvz.zombies;

import com.pvz.Map;

public class DolphinRiderZombie extends Zombie {
    private boolean alreadyJumped;
    
    public DolphinRiderZombie()
    {
        super("Dolphin Rider Zombie",175,100,1,true,5);
        alreadyJumped=false;
    }
    
    public void skill(Map map, int row, int col, Zombie zombie)
    {
        alreadyJumped=true;
        map.getTile(row, col).removePlant();
        map.getTile(row, col-1).addZombie(zombie);
        map.getTile(row, col).getListZombie().remove(zombie);
    }
    public boolean isAlreadyJumped() {
        return alreadyJumped;
    }

    public void setAlreadyJumped(boolean alreadyJumped) {
        this.alreadyJumped = alreadyJumped;
    }
}
