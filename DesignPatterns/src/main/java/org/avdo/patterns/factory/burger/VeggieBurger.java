package org.avdo.patterns.factory.burger;

public class VeggieBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing veggie burger");
    }
}
