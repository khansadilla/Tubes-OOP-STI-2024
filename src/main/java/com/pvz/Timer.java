package com.pvz;

public class Timer {
    private static Timer instance;
    private static long startTime;
    private static long currentTime = System.currentTimeMillis();
    private static long elapsedTime;
    
    public static Timer getInstance() {
        if (instance == null) {
            instance = new Timer();
            startTime=System.currentTimeMillis();
        }
        return instance;
    }
    
    public long getStartTime() {
        return startTime;
    }
    
    public static void  setStartTime(long start)
    {
        startTime=start;
    }
    
    public long getCurrentTime() {
        currentTime = System.currentTimeMillis();
        return currentTime;
    }
    
    public long getElapsedTime() {
        currentTime=System.currentTimeMillis();
        elapsedTime = (currentTime - startTime);
        return elapsedTime;
    }    
    public boolean zombieMove(long sinceLastMove)
    {
        if(getCurrentTime()-sinceLastMove>=10000) return true;
        return false;
    }
    public boolean Attack(long sinceLastAttack, int attackSpeed)
    {
        if(getCurrentTime()-sinceLastAttack>=attackSpeed*1000 || sinceLastAttack==0) return true;
        return false;
    }
    public boolean spawn(long sinceLastSpawn)
    {
        // && getElapsedTime()%200000>=20000/
        if((getCurrentTime()-sinceLastSpawn>=3000 || sinceLastSpawn==0)  && getElapsedTime()%200000<=160000 ) return true;
        return false;
    }
    public boolean isDay()
    {
        if(getElapsedTime()%200000<=100000) return true;
        return false;
    }
}
