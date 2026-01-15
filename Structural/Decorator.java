//Why Use This
//You can wrap objects on the fly without altering their code.
//You can stack decorators in different combinations — no subclass explosion.
//Supports Open/Closed Principle — you can add new features without modifying existing ones.



//How Decorators Avoid This
//With the Decorator Pattern, you don’t create new subclasses for every combination.
//Instead, you create small, reusable decorators that can be layered or “stacked” around the object at runtime.
//
//Example in Java:
//
//Coffee coffee = new SimpleCoffee();
//Coffee coffeeWithMilk = new MilkDecorator(coffee);
//Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);
//Coffee coffeeWithSugarThenMilk = new MilkDecorator(new SugarDecorator(coffee));
//Here:
//
//You reuse the same MilkDecorator and SugarDecorator classes.
//The order of stacking can be changed at will.
//No need for classes like MilkSugarCoffee — you just wrap objects dynamically.

// Component
interface Coffee {
    double cost();
    String description();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 5;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost();
    }

    @Override
    public String description() {
        return coffee.description();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 2;
    }

    @Override
    public String description() {
        return coffee.description() + ", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 1;
    }

    @Override
    public String description() {
        return coffee.description() + ", Sugar";
    }
}

// Usage
public class DecoratorExample {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.description() + " => $" + coffee.cost());

        Coffee coffeeWithMilk = new MilkDecorator(coffee);
        System.out.println(coffeeWithMilk.description() + " => $" + coffeeWithMilk.cost());

        Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);
        System.out.println(coffeeWithMilkAndSugar.description() + " => $" + coffeeWithMilkAndSugar.cost());
    }
}
