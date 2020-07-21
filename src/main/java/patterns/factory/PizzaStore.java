package patterns.factory;

import java.util.ArrayList;
import java.util.List;


abstract class Pizza {
    String name;
    String dough;
    String sauce;

    List<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("prepare " + name);
        System.out.println("Tossing dough ...");
        System.out.println("Adding sauce ...");
        System.out.println("Adding toppings: ");
        toppings.forEach(System.out::println);
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cut the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("----" + name + "----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        toppings.forEach(t -> display.append(t + "\n"));
        return display.toString();
    }
}

public abstract class PizzaStore {

    abstract Pizza createPizza(String item);

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        System.out.println("---Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String item) {
        if (item.equalsIgnoreCase("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (item.equalsIgnoreCase("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (item.equalsIgnoreCase("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else return null;
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}

class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza() {
        name = "Chicago Style Clam Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Frozen Clams form Chesapeake Bay");
    }

    void cut() {
        System.out.println("Cutting the pizza into squre slices");
    }
}

class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        name = "Chicago Style Pepperoni Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Black Olives");
        toppings.add("Spinach");
        toppings.add("Eggplant");
        toppings.add("Sliced Pepperoni");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}

class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        name = "Chicago Deep Dish Veggie Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Black Olives");
        toppings.add("Spinach");
        toppings.add("Eggplant");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slickes");
    }
}

class NYPizzaStore extends PizzaStore {
    Pizza createPizza(String item) {
        if (item.equalsIgnoreCase("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equalsIgnoreCase("veggie")) {
            return new NYStyleVeggiePizza();
        } else if (item.equalsIgnoreCase("clam")) {
            return new NYStyleClamPizza();
        } else if (item.equalsIgnoreCase("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else return null;
    }
}

class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}

class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        name = "NY Style Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }
}

class NYStylePepperoniPizza extends Pizza {

    public NYStylePepperoniPizza() {
        name = "NY Style Pepperoni Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Sliced Pepperoni");
        toppings.add("Garlic");
        toppings.add("Onion");
        toppings.add("Mushrooms");
        toppings.add("Red Pepper");
    }
}

class NYStyleVeggiePizza extends Pizza {

    public NYStyleVeggiePizza() {
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Garlic");
        toppings.add("Onion");
        toppings.add("Mushrooms");
        toppings.add("Red Pepper");
    }
}
