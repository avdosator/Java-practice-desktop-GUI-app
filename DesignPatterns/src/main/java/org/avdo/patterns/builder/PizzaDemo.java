package org.avdo.patterns.builder;

import java.util.Scanner;

public class PizzaDemo {

    public static void main(String[] args) {

        Pizza.PizzaBuilder pizzaBuilder = new Pizza.PizzaBuilder();
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Here you can order your pizza");

        System.out.println("Enter 1 if you want to add tomato");
        option = scanner.nextInt();
        pizzaBuilder.addTomato(option == 1);
        System.out.println("Enter 1 if you want to add cheese");
        option = scanner.nextInt();
        pizzaBuilder.addCheese(option == 1);
        System.out.println("Enter 1 if you want to add ham");
        option = scanner.nextInt();
        pizzaBuilder.addHam(option == 1);
        System.out.println("Enter 1 if you want to add mushrooms");
        option = scanner.nextInt();
        pizzaBuilder.addMushrooms(option == 1);
        System.out.println("Enter 1 if you want to add olives");
        option = scanner.nextInt();
        pizzaBuilder.addOlives(option == 1);
        System.out.println("Enter 1 if you want to add salami");
        option = scanner.nextInt();
        pizzaBuilder.addSalami(option == 1);
        Pizza pizza = pizzaBuilder.build();
        System.out.print("You have successfully ordered a pizza!");
        scanner.close();
    }
}
