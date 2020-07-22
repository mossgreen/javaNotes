package patterns.abstractFactory;

import java.util.List;
import java.util.stream.Collectors;

abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    List<String > veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    void bake() {
        System.out.println("bake for 25 minutes");
    }

    void cut() {
        System.out.println("cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("---" + name + "---\n");
        if (null != dough) {
            result.append(dough);
            result.append("\n");
        }

        if (null != sauce) {
            result.append(sauce);
            result.append("\n");
        }

        if (null != cheese) {
            result.append(cheese);
            result.append("\n");
        }

        if (null != veggies) {
            veggies.stream().collect(Collectors.joining(","))
            result.append("\n");
        }

        if (null != clams) {
            result.append(clams);
            result.append("\n");
        }

        if (null != pepperoni) {
            result.append(pepperoni);
            result.append("\n");
        }

        return result.toString();
    }
}

public abstract class PizzaStore {
    protected abstract Pizza createPizza(String item);

    public Pizza orderPizza(String type) {
        final Pizza pizza = createPizza(type);
        System.out.println("----Making a " + pizza.getName() + " ----");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
    }
}
