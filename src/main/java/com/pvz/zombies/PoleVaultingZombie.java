package com.pvz.zombies;

public class PoleVaultingZombie extends Zombie{
    private boolean alreadyPoleVaulted;
    public PoleVaultingZombie(long timeCreated)
    {
        super("Pole Vaulting Zombie", 175, 100, 1, false, 5,timeCreated);
        alreadyPoleVaulted=false;
    }
    public void poleVaulting()
    {
        
    }
    public boolean hasAlreadyPoleVaulted() {
        return alreadyPoleVaulted;
    }
}
