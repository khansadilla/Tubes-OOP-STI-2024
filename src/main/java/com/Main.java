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
    public static void print() {
        System.out.println("seconds: "+ seconds);
        System.out.println("current time main: " + Timer.getInstance().getCurrentTime()/1000);
        seconds++;
    }
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

        Thread thread = new Thread(() -> {
            try {
                while (true && !game.isGameOver()) {
                    game.update();
                    game.getMap().printMap(game);
                    // Main.print();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Game loop interrupted");
            }
        });
        thread.start();

        boolean isRunning = true;
        String userInput;

        while (isRunning) {
            System.out.println("Enter your command: ");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "exit":
                    System.out.println("Game is over.");
                    isRunning = false;
                    scanner.close();
                    thread.interrupt();
                    break;
                    // game.isGameOver = true;
                case "start":
                    System.out.println("Game is starting.");
                case "sun":
                    System.out.println("Sun: " + game.getSun());
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}


















