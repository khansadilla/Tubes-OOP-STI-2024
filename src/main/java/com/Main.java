package com;

import com.pvz.*;
import java.util.Scanner;

public class Main {
    public static void print() {
        System.out.println("Hello, World!");
    }
    public static void main(String args[]) {
        GameEntity game = new GameEntity();
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

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


















