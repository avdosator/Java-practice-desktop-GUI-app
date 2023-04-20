package org.avdo.patterns.factory.burger;

public class VeggieBurgerFactory extends Restaurant {
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
