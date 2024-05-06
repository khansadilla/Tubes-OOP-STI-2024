package com.pvz.zombies;

public class DolphinRiderZombie extends Zombie {
    private boolean alreadyJumped;
    public DolphinRiderZombie()
    {
        super("Dolphin Rider Zombie",175,100,1,true,5);
        alreadyJumped=false;
    }

    public void jumping()
    {
        
    }

    public boolean alreadyJumped() {
        return alreadyJumped;
    }
}
