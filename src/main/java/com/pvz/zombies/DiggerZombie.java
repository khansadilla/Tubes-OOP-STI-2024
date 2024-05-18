package com.pvz.zombies;

public class DiggerZombie extends Zombie {
    public boolean alreadySkipped;
    public DiggerZombie(long timeCreated)
    {
        super("Digger Zombie",175,100,1,false,5,timeCreated);
        alreadySkipped=false;
    }

    public void skipWallnut()
    {
        
    }

}
