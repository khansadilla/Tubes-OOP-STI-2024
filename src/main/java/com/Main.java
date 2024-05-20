package com;

import com.pvz.*;
import com.pvz.plants.Seed;

import java.util.Scanner;

public class Main {
    public static final String RESET = "\033[0m"; // Text Reset
    public static final String BLACK = "\033[0;30m"; // BLACK
    public static final String RED = "\033[0;31m"; // RED
    public static final String GREEN = "\033[0;32m"; // GREEN
    public static final String YELLOW = "\033[0;33m"; // YELLOW
    public static final String BLUE = "\033[0;34m"; // BLUE
    public static final String PURPLE = "\033[0;35m"; // PURPLE
    public static final String CYAN = "\033[0;36m"; // CYAN
    public static final String WHITE = "\033[0;37m"; // WHITE
    public static int seconds = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println(" ");
        String gameTitle = "\033[0;31m    ███▄ ▄███▓ ██▓ ▄████▄   ██░ ██  ▄▄▄      ▓█████  ██▓    \n" +
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
        // Scanner scanner = new Scanner(System.in);

        // Thread untuk update game
        Thread gameThread = new Thread(() -> {
            try {
                while (!game.isGameOver()) {
                    // game.getMap().printMap();
                    game.printGame();
                    Thread.sleep(2000); // Perbarui setiap detik
                }
            } catch (InterruptedException e) {
                System.out.println("Game loop interrupted");
            }
        });

        // Thread untuk aksi Zombie
        Thread zombieThread = new Thread(() -> {
            try {
                while (!game.isGameOver()) {
                    game.spawnZombieinRow();
                    game.getMap().checkAttackZombie();
                    game.getMap().checkMove(game);
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

        System.out.println("Welcome to Plants vs Zombies!");
        System.out.println("Here are some commands to get you started");
        
        // Thread utama untuk menerima input dari pengguna
        boolean isRunning = true;
        while (isRunning && !game.isGameOver()) {
            System.out.println("0. exit - Exit the game");
            System.out.println("1. Build deck -  Build your own deck");
            System.out.println("2. start - Start the game");
            System.out.println("3. help - list of commands");
            System.out.println("4. plants list - Lists of plants you can use");
            System.out.println("5. zombies list - List of zombies that can spawn");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    System.out.println("Building your deck");
                    buildDeck(game);
                    break;
                case "2":
                    System.out.println("Game is starting.");
                    gameThread.start();
                    // zombieThread.start();
                    plantThread.start();
                    while (!game.isGameOver() && isRunning) {
                        handleInput(game);
                    }
                    break;
                case "3":
                    game.getInventory().printInventory();
                default:
                    handleInput(game);
                    game.printGame();
            }
        }
        if (game.isGameOver() || !isRunning) {
            System.out.println("Game Over!");
            gameThread.interrupt();
            zombieThread.interrupt();
            plantThread.interrupt();
            scanner.close();
        }
    }

    public static void buildDeck(GameEntity game) {
        Inventory inventory = game.getInventory();
        Deck deck = game.getDeck();
        boolean isBuilding = true;
        while (isBuilding) {
            System.out.println("Build your deck");
            System.out.println("1. Add a seed");
            System.out.println("2. Remove a seed");
            System.out.println("3. Swap two seed");
            System.out.println("4. Exit building deck");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    boolean isAdding = true;
                    while (isAdding) {
                        System.out.println("Pick a seed");
                        inventory.printInventory();
                        deck.printDeck();
                        System.out.println("Enter 'exit' to stop adding seeds");
                        String seed = scanner.nextLine();
                        if (seed.equals("exit")) {
                            isAdding = false;
                        }
                        Seed seedInput = inventory.getSeed(seed);
                        try {
                            if (seedInput != null) {
                                deck.addSeed(seedInput);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "2":
                    System.out.println("Remove a seed");
                    System.out.println("Select a slot to remove:");
                    deck.printDeck();
                    int slot = scanner.nextInt();
                    try {
                        deck.removeSeed(slot);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case "3":
                    System.out.println("Swap two seeds to swap: ");
                    deck.printDeck();
                    System.out.println("Seed 1:");
                    int x = scanner.nextInt();
                    System.out.println("Seed 2:");
                    int y = scanner.nextInt();
                    try {
                        deck.swapSeeds(x-1, y-1);
                        System.out.println("Swap successful!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    deck.printDeck();
                    break;
                case "4":
                    isBuilding = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void handleInput(GameEntity game) {
        String input = scanner.nextLine();
        if (input.startsWith("plant ")) {
            String[] inputs = input.split(" ");
            if (inputs.length == 4) {
                int row = Integer.parseInt(inputs[1]);
                int col = Integer.parseInt(inputs[2]);
                String type = inputs[3];
                try {
                    game.plant(row, col, type);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid input");
            }
        } else if (input.equals("help")) {
            System.out.println("List of commands:");
            System.out.println("plant [row] [col] [type] - Plant a seed");
            System.out.println("help - List of commands");
        } else if (input.equals("List plants")) {
            System.out.println("List of plants:");
            System.out.println("Peashooter");
            System.out.println("Sunflower");
            System.out.println("Wallnut");
            System.out.println("Tallnut");
            System.out.println("Squash");
            System.out.println("Lilypad");
            System.out.println("Kelp");
            System.out.println("Snowpea");
            System.out.println("Sunbean");
            System.out.println("Jalapeno");
        } else if (input.equals("List zombies")) {
            System.out.println("List of zombies:");
            System.out.println("Normal Zombie");
            System.out.println("Conehead Zombie");
            System.out.println("Buckethead Zombie");
            System.out.println("Digger Zombie");
            System.out.println("Hulk Zombie");
            System.out.println("Dolphin Rider Zombie");
            System.out.println("Ducky Tube Zombie");
            System.out.println("Trex Zombie");
            System.out.println("Wizard Zombie");
            System.out.println("Pole Vaulting Zombie");
        } else if (input.equals("exit")) {
            game.setGameOver(true);
        } else {
            System.out.println("Invalid input");
        }
    }
}
