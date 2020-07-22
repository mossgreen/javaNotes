package patterns.abstractFactory;

import java.util.List;

interface Dough { public String toString(); }
interface Cheese { public String toString(); }
interface Sauce { public String toString(); }
interface Veggies { public String toString(); }
interface Pepperoni { public String toString(); }
interface Clams { public String toString(); }

class ThinCrustDough implements Dough {

    public String toString() {
        return "Thin Crust Dough";
    }
}

class ThickCrustDough implements Dough {
    public String toString() {
        return "Thick Crust style extra thick crust dough";
    }
}


public interface PizzaIngredientFactory {
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public List<Veggies> createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClams();

}

class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public List<Veggies> createVeggies() {
        return List.of(new GarLic(), new Onion(), new Mushroom(), new RedPepper());
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}


