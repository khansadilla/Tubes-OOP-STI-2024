package com.pvz.zombies;

import com.pvz.Map;

public class PoleVaultingZombie extends Zombie{
    private boolean alreadyPoleVaulted;
    public PoleVaultingZombie()
    {
        super("Pole Vaulting Zombie", "PVZ", 175, 100, 1, false, 5);
        alreadyPoleVaulted=false;
    }
    public void skill(Map map, int row, int col, Zombie zombie)
    {
        alreadyPoleVaulted=true;
        map.getTile(row, col).removePlant();
        map.getTile(row, col-1).addZombie(zombie);
        map.getTile(row, col).getListZombie().remove(zombie);
    }
    public boolean isAlreadyPoleVaulted() {
        return alreadyPoleVaulted;
    }
    public void setAlreadyPoleVaulted(boolean alreadyPoleVaulted) {
        this.alreadyPoleVaulted = alreadyPoleVaulted;
    }
}
