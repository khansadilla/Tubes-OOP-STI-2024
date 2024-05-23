package com.pvz.zombies;

import com.pvz.Map;

public class HulkZombie extends Zombie{
    private boolean alreadySquashed;
    public HulkZombie()
    {
        super("Hulk Zombie", "HZ", 200,100,1,false,5);
        alreadySquashed=false;
    }

    public void skill(Map map, int row, int col)
    {
        alreadySquashed=true;
        map.getTile(row, col).removePlant();
    }
    public boolean isAlreadySquashed() {
        return alreadySquashed;
    }
    public void setAlreadySquashed(boolean alreadySquashed) {
        this.alreadySquashed = alreadySquashed;
    }
    
}
