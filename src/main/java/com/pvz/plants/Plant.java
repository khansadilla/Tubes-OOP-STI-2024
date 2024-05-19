package com.pvz.plants;
import com.pvz.zombies.*;

public abstract class Plant {
    private String name;
    private int cost;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private int cooldown;
    private boolean is_aquatic;
    private long sinceLastAttack;

    // public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown, boolean is_aquatic) {
    //     this.name = name;
    //     this.cost = cost;
    //     this.health = health;
    //     this.attack_damage = attack_damage;
    //     this.attack_speed = attack_speed;
    //     this.range = range;
    //     this.cooldown = cooldown;
    //     this.is_aquatic = is_aquatic;
    // }

    public Plant(String name, 
                 int cost, 
                 int health, 
                 int attack_damage, 
                 int attack_speed, 
                 int range, 
                 int cooldown,
                 boolean is_aquatic){
        this.name=name;
        this.cost=cost;
        this.health=health;
        this.attack_damage=attack_damage;
        this.attack_speed=attack_speed;
        this.range=range;
        this.cooldown=cooldown;
        this.is_aquatic=is_aquatic;
        sinceLastAttack=0;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attack_damage;
    }

    public int getAttackSpeed() {
        return attack_speed;
    }

    public int getRange() {
        return range;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isAquatic() {
        return is_aquatic;
    }

    public void attack(Zombie zombie) {
        zombie.setHealth(zombie.getHealth()-attack_damage);
    }

    public long getSinceLastAttack()
    {
        return sinceLastAttack;
    }

    public void setSinceLastAttack(long sinceLastAttack)
    {
        this.sinceLastAttack=sinceLastAttack;
    }
}
