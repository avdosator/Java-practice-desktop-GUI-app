package org.avdo.patterns.templateMethod;

import java.util.Scanner;

public abstract class HotDrink {

    private int sugar;
    private boolean honey;
    private int milk;

    public void prepareDrink(Scanner scanner) {
        brew();
        addCondiments(scanner);
        serve();
    }

    public int getSugar() {
        return sugar;
    }

    public boolean getHoney() {
        return honey;
    }

    public int getMilk() {
        return milk;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setHoney() {
        this.honey = true;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public abstract void brew();
    public abstract void addCondiments(Scanner scanner);
    public abstract void serve();





}
