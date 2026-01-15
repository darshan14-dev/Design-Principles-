
//Step 1: Abstract Products

// Enemy
public interface Enemy {
    void attack();
}

// Weapon
public interface Weapon {
    void use();
}


//Step 2: Concrete Products
public class Goblin implements Enemy {
    public void attack() {
        System.out.println("Goblin attacks with sword!");
    }
}

public class Sword implements Weapon {
    public void use() {
        System.out.println("Swinging a sharp sword!");
    }
}

//Concrete Products for Medieval Theme
public class Robot implements Enemy {
    public void attack() {
        System.out.println("Robot attacks with laser gun!");
    }
}

//Concrete Products for Sci‑Fi Theme
public class LaserGun implements Weapon {
    public void use() {
        System.out.println("Firing a laser beam!");
    }
}


//3. Abstract Factory
public interface GameAssetFactory {
    Enemy createEnemy();
    Weapon createWeapon();
}


//4.Concrete Factories
public class MedievalFactory implements GameAssetFactory {
    public Enemy createEnemy() {
        return new Goblin();
    }
    public Weapon createWeapon() {
        return new Sword();
    }
}

public class SciFiFactory implements GameAssetFactory {
    public Enemy createEnemy() {
        return new Robot();
    }
    public Weapon createWeapon() {
        return new LaserGun();
    }
}

//Client Code

public class Game {
    private Enemy enemy;
    private Weapon weapon;

    public Game(GameAssetFactory factory) {
        enemy = factory.createEnemy();
        weapon = factory.createWeapon();
    }

    public void play() {
        enemy.attack();
        weapon.use();
    }

    public static void main(String[] args) {
        // Choose theme — could be from config or user input
        String theme = "SciFi";

        GameAssetFactory factory;
        if (theme.equalsIgnoreCase("Medieval")) {
            factory = new MedievalFactory();
        } else {
            factory = new SciFiFactory();
        }

        Game game = new Game(factory);
        game.play();
    }
}
