package patterns.abstractFactory;

import java.util.List;

interface Dough { public String toString(); }
interface Cheese { public String toString(); }
interface Sauce { public String toString(); }
interface Veggie { public String toString(); }
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

class MozzarellaCheese implements Cheese {
    public String toString() {
        return "Shredded Mozzarella Cheese";
    }
}

class ParmesanCheese implements Cheese {
    public String toString() {
        return "Shredded Parmesan Cheese";
    }
}

class ReggianoCheese implements Cheese {
    public String toString() {
        return "Reggiano Cheese";
    }
}

class MarinaraSauce implements Sauce {
    public String toString() {
        return "Marinara Sauce";
    }
}

class PlumTomatoSauce implements Sauce {
    public String toString() {
        return "Tomato sauce with plum tomatoes";
    }
}

class BlackOlives implements Veggie {
    public String toString() {
        return "Black Olives";
    }
}

class Eggplant implements Veggie {
    public String toString() {
        return "Eggplant";
    }
}

class Garlic implements Veggie {
    public String toString() {
        return "Garlic";
    }
}

class Mushroom implements Veggie {

    public String toString() {
        return "Mushrooms";
    }
}

class Onion implements Veggie {
    public String toString() {
        return "Onion";
    }
}

class RedPepper implements Veggie {

    public String toString() {
        return "Red Pepper";
    }
}

class Spinach implements Veggie {
    public String toString() {
        return "Spinach";
    }
}

class SlicedPepperoni implements Pepperoni {
    public String toString() {
        return "Sliced pepperoni";
    }
}

class FreshClams implements Clams {
    public String toString() {
        return "Refresh Clams from Long Island Sound";
    }
}

class FrozenClams implements Clams {
    public String toString() {
        return "Frozen Clams from Chesapeake Bay";
    }
}


public interface PizzaIngredientFactory {
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public List<Veggie> createVeggies();

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
    public List<Veggie> createVeggies() {
        return List.of(new Garlic(), new Onion(), new Mushroom(), new RedPepper());
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

class ChicagoIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public List<Veggie> createVeggies() {
        return List.of(new BlackOlives(), new Onion(), new Mushroom(), new RedPepper());
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }

}


