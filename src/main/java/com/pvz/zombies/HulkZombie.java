package com.pvz.zombies;

public class HulkZombie extends Zombie{
    private boolean alreadySquashed;
    public HulkZombie()
    {
        super("Hulk Zombie", 200,100,1,false,5);
        alreadySquashed=false;
    }

    public void plantSquashing()
    {
        
    }

    public boolean hasAlreadySquashed() {
        return alreadySquashed;
    }
}
