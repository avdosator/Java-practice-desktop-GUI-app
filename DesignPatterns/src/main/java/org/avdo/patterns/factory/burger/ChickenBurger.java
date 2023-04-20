package org.avdo.patterns.factory.burger;

public class ChickenBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing chicken burger");
    }
}
