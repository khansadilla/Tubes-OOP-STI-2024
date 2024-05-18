package com.pvz.zombies;

public class DolphinRiderZombie extends Zombie {
    private boolean alreadyJumped;
    public DolphinRiderZombie(long timeCreated)
    {
        super("Dolphin Rider Zombie",175,100,1,true,5,timeCreated);
        alreadyJumped=false;
    }

    public void jumping()
    {
        
    }

    public boolean alreadyJumped() {
        return alreadyJumped;
    }
}
