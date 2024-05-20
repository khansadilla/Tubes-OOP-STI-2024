package com.pvz.zombies;
import com.pvz.plants.*;
import com.pvz.Timer;
public abstract class Zombie {
    private String name;
    private int health;
    private int attackDamage;
    private int attackSpeed;
    private boolean isAquatic;
    private int movementSpeed;
    private long timeCreated;
    private long sinceLastAttack;
    private long sinceLastMove;
    private static int totalZombie=0;
    
    
    Timer time=new Timer();
    
    public Zombie(String name, int health, int attackDamage, int attackSpeed, boolean isAquatic,  int movementSpeed)
    {
        this.name=name;
        this.health=health;
        this.attackDamage=attackDamage;
        this.attackSpeed=attackSpeed;
        this.isAquatic=isAquatic;
        this.movementSpeed=movementSpeed;
        sinceLastAttack=0;
        timeCreated=time.getCurrentTime();
        sinceLastMove=timeCreated;
    }
    
    public void attack(Plant plant)
    {
        plant.setHealth(plant.getHealth()-attackDamage);
    }
    public String getName()
    {
        return name;
    }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health=health;
    }
    public int getAttackDamage()
    {
        return attackDamage;
    }
    public int getAttackSpeed()
    {
        return attackSpeed;
    }
    public void setAttack_speed(int attackSpeed)
    {
        this.attackSpeed=attackSpeed;
    }
    public boolean getIs_aquatic()
    {
        return isAquatic;
    }
    public int getMovementSpeed()
    {
        return movementSpeed;
    }
    public void setMovementSpeed(int movementSpeed)
    {
        this.movementSpeed=movementSpeed;
    }
    public long getTimeCreated()
    {
        return timeCreated;
    }
    public void setTimeCreated(long timeCreated)
    {
        this.timeCreated=timeCreated;
    }
    
    public long getSinceLastAttack()
    {
        return sinceLastAttack;
    }
    
    public void setSinceLastAttack(Long sinceLastAttack)
    {
        this.sinceLastAttack=sinceLastAttack;
    }
    
    public long getSinceLastMove() {
        return sinceLastMove;
    }
    
    public void setSinceLastMove(long sinceLastMove) {
        this.sinceLastMove = sinceLastMove;
    }
    public static int getTotalZombie() {
        return totalZombie;
    }
    
    public static void setTotalZombie(int totalZombie) {
        Zombie.totalZombie = totalZombie;
    }
}
