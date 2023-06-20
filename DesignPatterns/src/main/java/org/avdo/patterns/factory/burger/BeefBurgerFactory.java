package org.avdo.patterns.factory.burger;

public class BeefBurgerFactory extends Restaurant {
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
