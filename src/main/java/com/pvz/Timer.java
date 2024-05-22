package com.pvz;

public class Timer {
    private static Timer instance;
    private static long startTime;
    private static long currentTime = System.currentTimeMillis();
    private static long elapsedTime;
    
    public Timer() {
        startTime = currentTime;
    }

    public static Timer getInstance() {
        if (instance == null) {
            instance = new Timer();
        }
        return instance;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getCurrentTime() {
        currentTime = System.currentTimeMillis();
        return currentTime;
    }

    public long getElapsedTime() {
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
        if((getCurrentTime()-sinceLastSpawn>=3000 || sinceLastSpawn==0) && getElapsedTime()%200000>=20000 && getElapsedTime()%200000<=160000 ) return true;
        return false;
    }
    public boolean isDay()
    {
        if(getElapsedTime()%200000<=100000) return true;
        return false;
    }
}
