package com.pvz.zombies;

public class NormalZombie extends Zombie{
    public NormalZombie(long timeCreated)
    {
        super("Normal Zombie", 125, 100, 1, false,  5,timeCreated);
    }
}
