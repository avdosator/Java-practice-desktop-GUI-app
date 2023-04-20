package org.avdo.patterns.factory.burger;

public class EggBurgerFactory extends Restaurant {
    @Override
    public Burger createBurger() {
        return new EggBurger();
    }
}
