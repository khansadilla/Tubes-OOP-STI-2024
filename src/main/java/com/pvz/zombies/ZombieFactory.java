package com.pvz.zombies;

import com.pvz.Interface.Factory;
import com.pvz.ExceptionHandling.*;;

public class ZombieFactory implements Factory<Zombie> {
    @Override
    public Zombie create(long timeCreated, String type) throws IllegalTypeException {
        switch (type) {
            case "Normal Zombie":
                return new NormalZombie();
            case "Conehead Zombie":
                return new ConeheadZombie();
            case "Buckethead Zombie":
                return new BucketHeadZombie();
            case "Digger Zombie":
                return new DiggerZombie();
            case "Hulk Zombie":
                return new HulkZombie();
            case "Pole Vaulting Zombie":
                return new PoleVaultingZombie();
            case "Trex Zombie":
                return new TrexZombie();
            case "Wizard Zombie":
                return new WizardZombie();
            case "Ducky Tube Zombie":
                return new DuckyTubeZombie();
            case "Dolphin Rider Zombie":
                return new DolphinRiderZombie();
            default:
                throw new IllegalTypeException("Zombie type not found.");
        }
    }
}
