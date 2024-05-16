package com;

import com.pvz.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        GameEntity game = new GameEntity();
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        Thread thread = new Thread(() -> {
            try {
                while (true && !game.isGameOver()) {
                    // game.update();
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
                    // game.isGameOver = true;
                case "print":
                    game.getMap().printMap(game);
                case "sun":
                    System.out.println("Sun: " + game.getSun());
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}


















