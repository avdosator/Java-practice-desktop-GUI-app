package org.avdo.patterns.factory.burger;

public class EggBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing egg burger");
    }
}
