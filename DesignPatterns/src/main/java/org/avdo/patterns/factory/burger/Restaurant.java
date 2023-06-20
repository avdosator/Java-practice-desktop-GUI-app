package org.avdo.patterns.factory.burger;

public abstract class Restaurant {

    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();

    public static void main(String[] args) {
        Restaurant restaurant = new BeefBurgerFactory();
        Burger burger = restaurant.orderBurger();
    }

}
