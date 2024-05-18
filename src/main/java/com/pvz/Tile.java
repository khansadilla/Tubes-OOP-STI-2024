package com.pvz;
import java.util.List;
import com.pvz.plants.Plant;
import com.pvz.zombies.Zombie;
import com.pvz.Timer;
import java.util.ArrayList;
import java.util.Vector;
public abstract class Tile {
    private String type;
    private boolean isOccupiedByPlant;
    private boolean isOccupiedByZombie;
    private List<Zombie> ZombieList;
    private Plant plant;
    Timer time=new Timer();

    public Tile(){
        List<Zombie> ZombieList=new ArrayList<>();
        Plant plant=null;
    }

    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
    public boolean isOccupiedByPlant(){
        return !(plant==null);
    }
    public boolean isOccupiedByZombie()
    {
        return !ZombieList.isEmpty();
    }
    public abstract boolean isPlantValid(Plant plant);

    public void addZombie(Zombie zombie)
    {
        ZombieList.add(zombie);
    }

    public void addPlant(Plant plant)
    {
        this.plant=plant;
    }

    public List<Zombie> moveZombie()
    {
        @SuppressWarnings("rawtypes")
        List<Zombie> movZombies = new ArrayList();
        for(Zombie zombie : ZombieList)
        {
            if(time.zombieMove(zombie.getTimeCreated()))
            {
                movZombies.add(zombie);
            }
        }
        ZombieList.removeIf(zombie->time.zombieMove(zombie.getTimeCreated()));
        return movZombies;
    }

    public void zombieAttack()
    {
        for(Zombie zombie : ZombieList)
        {
            if(time.Attack(zombie.getSinceLastAttack(), zombie.getAttackSpeed()))
            {zombie.attack(plant); zombie.setSinceLastAttack(time.getCurrentTime());}
        }
        if(plant.getHealth()<=0) plant=null;
    }

    public Plant getPlant()
    {
        return plant;
    }

    public List<Zombie> getListZombie()
    {
        return ZombieList;
    }
}
