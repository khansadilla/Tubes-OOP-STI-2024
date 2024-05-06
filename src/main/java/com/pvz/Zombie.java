package com.pvz;

public abstract class Zombie {
    private String name;
    private int health;
    private int attackDamage;
    private int attackSpeed;
    private boolean isAquatic;
    private Point position;
    private int movementSpeed;
    
    public Zombie(String name, int health, int attackDamage, int attackSpeed, boolean isAquatic,  int movementSpeed)
    {
        this.name=name;
        this.health=health;
        this.attackDamage=attackDamage;
        this.attackSpeed=attackSpeed;
        this.isAquatic=isAquatic;
        this.movementSpeed=movementSpeed;
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
    public Point getPosition()
    {
        return position;
    }
    public void setPosition(Point point)
    {
        this.position=point;
    }
    public int getMovementSpeed()
    {
        return movementSpeed;
    }
    public void setMovementSpeed(int movementSpeed)
    {
        this.movementSpeed=movementSpeed;
    }
}
