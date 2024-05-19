package com;

import com.pvz.*;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\033[0m";      // Text Reset
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static int seconds = 0;

    public static void main(String args[]) {
        System.out.println(" ");
        String gameTitle = 
            "\033[0;31m    ███▄ ▄███▓ ██▓ ▄████▄   ██░ ██  ▄▄▄      ▓█████  ██▓    \n" +
            "   ▓██▒▀█▀ ██▒▓██▒▒██▀ ▀█  ▓██░ ██▒▒████▄    ▓█   ▀ ▓██▒    \n" +
            "   ▓██    ▓██░▒██▒▒▓█    ▄ ▒██▀▀██░▒██  ▀█▄  ▒███   ▒██░    \n" +
            "   ▒██    ▒██ ░██░▒▓▓▄ ▄██▒░▓█ ░██ ░██▄▄▄▄██ ▒▓█  ▄ ▒██░    \n" +
            "   ▒██▒   ░██▒░██░▒ ▓███▀ ░░▓█▒░██▓ ▓█   ▓██▒░▒████▒░██████▒\n" +
            "   ░ ▒░   ░  ░░▓  ░ ░▒ ▒  ░ ▒ ░░▒░▒ ▒▒   ▓▒█░░░ ▒░ ░░ ▒░▓  ░\n" +
            "                  ░ ░                                        \n\033[0m" +
            "                     ░██▒   █▓  ██████ \n" +
            "                     ▓██░   █▒▒██    ▒ \n" +
            "                      ▓██  █▒░░ ▓██▄   \n" +
            "                       ▒██ █░░  ▒   ██▒\n" +
            "                        ▒▀█░  ▒██████▒▒\n" +
            "                        ░ ▐░  ▒ ▒▓▒ ▒ ░\n" +
            "                        ░ ░░  ░ ░▒  ░ ░\n" +
            "\033[0;32m ██▓    ▄▄▄       ██▓    ▄▄▄       ██▓███   ▄▄▄       ███▄    █ \n" +
            "▓██▒   ▒████▄    ▓██▒   ▒████▄    ▓██░  ██▒▒████▄     ██ ▀█   █ \n" +
            "▒██░   ▒██  ▀█▄  ▒██░   ▒██  ▀█▄  ▓██░ ██▓▒▒██  ▀█▄  ▓██  ▀█ ██▒\n" +
            "▒██░   ░██▄▄▄▄██ ▒██░   ░██▄▄▄▄██ ▒██▄█▓▒ ▒░██▄▄▄▄██ ▓██▒  ▐▌██▒\n" +
            "░██████▒▓█   ▓██▒░██████▒▓█   ▓██▒▒██▒ ░  ░ ▓█   ▓██▒▒██░   ▓██░\n" +
            "░ ▒░▓  ░▒▒   ▓▒█░░ ▒░▓  ░▒▒   ▓▒█░▒▓▒░ ░  ░ ▒▒   ▓▒█░░ ▒░   ▒ ▒ \n" +
            "    ░  ░     ░  ░    ░  ░     ░  ░               ░  ░         ░ \n\033[0m" +
            "                                                                ";
        System.out.println(gameTitle);
        

        GameEntity game = new GameEntity();
        Scanner scanner = new Scanner(System.in);

        // Thread untuk update game
        Thread gameThread = new Thread(() -> {
            try {
                while (!game.isGameOver()) {
                    // game.getMap().printMap();
                    Thread.sleep(1000); // Perbarui setiap detik
                }
            } catch (InterruptedException e) {
                System.out.println("Game loop interrupted");
            }
        });

        // Thread untuk aksi Zombie
        Thread zombieThread = new Thread(() -> {
            try {
                while (!game.isGameOver()) {
                    game.getMap().checkAttackZombie();
                    game.getMap().checkMove();
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
                    game.getMap().checkAttackPlant();
                    Thread.sleep(1000); // Perbarui setiap detik
                }
            } catch (InterruptedException e) {
                System.out.println("Plant loop interrupted");
            }
        });
        

        // Thread utama untuk menerima input dari pengguna
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter your command: ");
            String userInput = scanner.nextLine();
            switch (userInput) {
                // case "":
                //     game.getMap().printMap();
                case "exit":
                    System.out.println("Game is over.");
                    isRunning = false;
                    gameThread.interrupt();
                    zombieThread.interrupt();
                    plantThread.interrupt();
                    break;
                case "start":
                    // build deck
                    
                    System.out.println("Game is starting.");
                    gameThread.start();
                    zombieThread.start();
                    plantThread.start();
                    break;
                case "sun":
                    System.out.println("Sun: " + game.getSun());
                    break;
                case "select seed":
                default:
                    game.getMap().printMap();
            }
        }

        scanner.close();
    }
}
