package org.avdo.patterns.templateMethod;

import java.util.Scanner;

public class HotDrinkDispenser {

    private final Scanner scanner;

    public HotDrinkDispenser() {
        this.scanner = new Scanner(System.in);
    }

    public void dispenseTea() {
        Tea tea = new Tea();
        tea.prepareDrink(scanner);
    }

    public void dispenseCoffee() {
        Coffee coffee = new Coffee();
        coffee.prepareDrink(scanner);
    }

    public void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        HotDrinkDispenser hotDrinkDispenser = new HotDrinkDispenser();
        hotDrinkDispenser.dispenseTea();
        hotDrinkDispenser.dispenseCoffee();
        hotDrinkDispenser.closeScanner();
    }
}
