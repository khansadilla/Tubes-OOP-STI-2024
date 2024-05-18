// Abstract Product: Karakter
interface Character {
    void display();
}

// Concrete Products: Karakter
class Elf implements Character {
    public void display() {
        System.out.println("Menampilkan karakter Elf.");
    }
}

class Orc implements Character {
    public void display() {
        System.out.println("Menampilkan karakter Orc.");
    }
}

// Abstract Product: Senjata
interface Weapon {
    void display();
}

// Concrete Products: Senjata
class Sword implements Weapon {
    public void display() {
        System.out.println("Menampilkan pedang.");
    }
}

class Bow implements Weapon {
    public void display() {
        System.out.println("Menampilkan busur.");
    }
}

// Abstract Factory: Game Element Factory
interface GameElementFactory {
    Character createCharacter();
    Weapon createWeapon();
}

// Concrete Factory: Factory untuk Game Fantasy
class FantasyGameElementFactory implements GameElementFactory {
    public Character createCharacter() {
        return new Elf(); 
    }

    public Weapon createWeapon() {
        return new Sword();
    }
}

// Concrete Factory: Factory untuk Game Sci-Fi
class SciFiGameElementFactory implements GameElementFactory {
    public Character createCharacter() {
        return new Orc(); 
    }

    public Weapon createWeapon() {
        return new Bow(); 
    }
}

// Client: Game
public class Game {
    private GameElementFactory factory;

    public Game(GameElementFactory factory) {
        this.factory = factory;
    }

    public void start() {
        System.out.println("Memulai permainan...");

        Character character = factory.createCharacter();
        Weapon weapon = factory.createWeapon();

        System.out.println("Membuat karakter dan senjata:");
        character.display();
        weapon.display();

        System.out.println("Permainan dimulai!");
    }

    public static void main(String[] args) {
        Game fantasyGame = new Game(new FantasyGameElementFactory());
        fantasyGame.start();

        Game sciFiGame = new Game(new SciFiGameElementFactory());
        sciFiGame.start();
    }
}
