package com;

import com.pvz.*;
import com.pvz.plants.Seed;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

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
        
        Action action=new Action();
        // Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Plants vs Zombies!");
        System.out.println("Here are some commands to get you started");
        
        // Thread utama untuk menerima input dari pengguna
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("0. exit - Exit the game");
            System.out.println("1. start - Start the game");
            System.out.println("2. build deck -  Build your own deck");
            System.out.println("3. open inventory - List of plants you can use");
            System.out.println("4. help - list of commands");
            System.out.println("5. plants list - Lists of plants you can use");
            System.out.println("6. zombies list - List of zombies that can spawn");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    if (game.getDeck().isFull()) {
                        System.out.println("Game is starting.");
                        game.gameReset();                  
                        action.startGame(game);
                        while (!game.isGameOver() && isRunning) {
                            handleInput(game);
                        }
                    } else {
                        System.out.println("Deck is not full. Please build your deck first");
                    }
                    break;
                case "2":
                    System.out.println("Building your deck");
                    buildDeck(game);
                    break;
                case "3":
                    game.getInventory().printInventory();
                    printSwapSeedinInventory(game);
                    break;
                case "4":
                    break;
                case "5":
                    printZombieList();
                default:
                    handleInput(game);
                    game.printGame();
            }
        }
        if (!isRunning) {
            System.out.println("See you next time!");
            return;
        }
    }

    public static void buildDeck(GameEntity game) {
        Inventory inventory = game.getInventory();
        Deck deck = game.getDeck();
        boolean isBuilding = true;
        while (isBuilding) {
            System.out.println("Build your deck");
            System.out.println("0. Exit building deck");
            System.out.println("1. Add a seed");
            System.out.println("2. Remove a seed");
            System.out.println("3. Swap two seed");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    boolean isAdding = true;
                    while (isAdding) {
                        Integer seed;
                        while (true) {
                        System.out.println("Pick a seed");
                        inventory.printInventory();
                        deck.printDeck();
                        System.out.println("Enter '0' to stop adding seeds");
                        // String seed = scanner.nextLine();
                            try {
                                seed = scanner.nextInt();
                                if (seed < 0 || seed > inventory.getSeeds().size()) {
                                    System.out.println("Invalid input");
                                } else {
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input");
                                scanner.nextLine();
                            }
                        }
                        if (seed.equals(0)) {
                            isAdding = false;
                        } 
                        Seed seedInput = inventory.getSeedInt(seed);
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
                    if (deck.isEmpty()) {
                        System.out.println("Deck is empty");
                        break;
                    }
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
                case "0":
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
                int row = Integer.parseInt(inputs[1]) - 1;
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
        } else if (input.startsWith("dig ")) {
            String[] inputs = input.split(" ");
            if (inputs.length == 3) {
                int row = Integer.parseInt(inputs[1]) - 1;
                int col = Integer.parseInt(inputs[2]);
                try {
                    game.getMap().getTile(row, col).removePlant();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid input");
            }
        } else if (input.equals("help")) {
            printHelp();
        } else if (input.equals("List plants")) {
            game.getInventory().printInventory();
        } else if (input.equals("List zombies")) {
            printZombieList();
        } 
        else if (input.equals("exit")) {
            game.setGameOver(true);
        } 
        else if (input.equals("")) game.printGame();
        else {
            System.out.println("Invalid input");
        }
    }
    public static void printZombieList() {
        System.out.println("List of zombies:");
        System.out.println("1. Normal Zombie");
        System.out.println("2. Conehead Zombie");
        System.out.println("3. Buckethead Zombie");
        System.out.println("4. Digger Zombie");
        System.out.println("5. Hulk Zombie");
        System.out.println("6. Dolphin Rider Zombie");
        System.out.println("7. Ducky Tube Zombie");
        System.out.println("8. Trex Zombie");
        System.out.println("9. Wizard Zombie");
        System.out.println("10. Pole Vaulting Zombie");
    }
    public static void printHelp() {
        System.out.println("List of commands in the main menu: ");
        System.out.println("0. exit - Exit the game");
        System.out.println("1. start - Start the game");
        System.out.println("2. build deck -  Build your own deck");
        System.out.println("3. open inventory - List of plants you can use");
        System.out.println("4. help - list of commands");
        System.out.println("5. plants list - Lists of plants you can use");
        System.out.println("6. zombies list - List of zombies that can spawn");
        System.out.println("List of commands in the game: ");
        System.out.println("plant <row> <col> <plant type> - Plant a plant in a tile");
        System.out.println("dig <row> <col> - Remove a plant from a tile");
        System.out.println("help - List of commands");
        System.out.println("exit - Exit the game");
    }
    public static void printSwapSeedinInventory(GameEntity game) {
        System.out.println("Would you like to swap seeds? (y/n)");
        while (true) {
            String swap = scanner.nextLine();
            if (swap.equals("y")) {
                System.out.println("Enter the slot number of the seeds you want to swap");
                game.getDeck().printDeck();
                System.out.println("Seed 1:");
                int x = scanner.nextInt();
                System.out.println("Seed 2:");
                int y = scanner.nextInt();
                try {
                    game.getInventory().swapSeeds(x-1, y-1);
                    System.out.println("Swap successful!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                game.getInventory().printInventory();
                break;
            } else if (swap.equals("n")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
