package org.avdo.patterns.templateMethod;

import java.util.Scanner;

public class Coffee extends HotDrink {
    @Override
    public void brew() {
        System.out.println("Coffee is brewing");
    }

    @Override
    public void addCondiments(Scanner scanner) {
        System.out.println("Enter amount of sugar");
        this.setSugar(scanner.nextInt());
        System.out.println("Enter amount of milk");
        this.setMilk(scanner.nextInt());
    }

    @Override
    public void serve() {
        System.out.printf("You ordered a coffee with %d sugar and %d milk\n",getSugar(), getMilk());
        System.out.println("Here is your coffee");
    }
}
