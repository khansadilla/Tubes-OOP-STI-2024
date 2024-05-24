package com;

import java.util.concurrent.atomic.AtomicLong;

import com.pvz.GameEntity;
import com.pvz.Timer;
import com.pvz.Sun;

public class Action {
    
    public void startGame(GameEntity game)
    {
        Sun sun = Sun.getInstance();
        
        AtomicLong sinceLastSpawn = new AtomicLong(0);
        Timer time = Timer.getInstance();
        
        Thread zombieThread = new Thread(() -> {
            try {
                while (!game.isGameOver()) {
                    synchronized (game)
                    {
                        if (time.spawn(sinceLastSpawn.get())) {
                            game.getMap().checkAttackZombie();
                            game.spawnZombieinRow();
                            sinceLastSpawn.set(time.getCurrentTime());
                        }
                        game.getMap().checkAttackZombie();
                        game.getMap().checkMove(game);
                    }
                    Thread.sleep(1000); // Perbarui setiap detik
                }
            } catch (InterruptedException e) {
                System.out.println("Zombie loop interrupted");
            }
        });
        
        // Thread untuk aksi Plant
        Thread plantThread = new Thread(() -> {
            try {
                while (!game.isGameOver()) {
                    synchronized(game)
                    {
                        game.getMap().checkAttackPlant();
                        game.getMap().checkSkillPlant();
    
                    }
                    Thread.sleep(1000); // Perbarui setiap detik
                }
            } catch (InterruptedException e) {
                System.out.println("Plant loop interrupted");
            }
        });
        
        Thread gameThread = new Thread(() -> {
            try {
                while (!game.isGameOver()) {
                    sun.generateSun();
                    game.checkGameOver();
                    if(game.isGameOver())
                    {
                        zombieThread.interrupt();
                        plantThread.interrupt();
                    }
                    // game.getMap().printMap();
                    Thread.sleep(1000); // Perbarui setiap detik
                }
            } catch (InterruptedException e) {
                System.out.println("Game loop interrupted");
            }
        });
        gameThread.start();
        zombieThread.start();
        plantThread.start();
        Timer.setStartTime(time.getCurrentTime());
    }
    
}
