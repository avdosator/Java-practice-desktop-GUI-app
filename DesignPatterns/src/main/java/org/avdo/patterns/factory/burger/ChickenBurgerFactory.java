package org.avdo.patterns.factory.burger;

public class ChickenBurgerFactory extends Restaurant {
    @Override
    public Burger createBurger() {
        return new ChickenBurger();
    }
}
