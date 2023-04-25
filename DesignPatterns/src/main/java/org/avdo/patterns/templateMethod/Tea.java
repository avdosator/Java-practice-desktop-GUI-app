package org.avdo.patterns.templateMethod;

import java.util.Scanner;

public class Tea extends HotDrink {
    @Override
    public void brew() {
        System.out.println("Tea is brewing");
    }

    @Override
    public void addCondiments(Scanner scanner) {

        System.out.println("Please enter amount of sugar: ");
        int sugar = scanner.nextInt();
        this.setSugar(sugar);
        scanner.nextLine();
        System.out.println("Do you want honey (type \"yes\" or \"no\")");
        String honeyAnswer = scanner.nextLine();
        if (honeyAnswer.equalsIgnoreCase("yes")) {
            setHoney();
        }
    }

    @Override
    public void serve() {
        System.out.printf("You ordered a tea with %d sugar ",getSugar());
        if (getHoney()) {
            System.out.print("and honey\n");
        } else {
            System.out.println();
        }
        System.out.println("Here is your tea");
    }
}
