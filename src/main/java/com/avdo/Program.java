package com.avdo;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Phonebook phonebook = new Phonebook();
        System.out.println("**Welcome to  phonebook app**");
        int option;

        do {
            System.out.println();
            System.out.printf("Press \"1\" if you want to add new entry,\nPress \"2\" if you want to use some " +
                    "searching options,\nPress \"0\" if you want to exit:\n");
            option = scanner.nextInt();

            if (option == 0) {
                return;
            } else if (option == 1) {
                System.out.println("Choose an option:");
                System.out.print("Press \"1\" if you want to add mobile number\n" +
                        "Press \"2\" if you want to add home phone number\n" +
                        "Press \"3\" if you want to add international phone number\n");
                int entry = scanner.nextInt();
                scanner.nextLine();

                if (entry == 1) {
                    System.out.println("Enter a provider (60-67)");
                    int provider = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter a number in form \"111-111\"");
                    String number = scanner.nextLine();
                    PhoneNumber p = null;
                    try {
                        p = MobilePhoneNumber.createNumber(provider, number);
                    } catch (IllegalInputException e) {
                        System.out.println("Action not completed, try to enter valid arguments.");
                        continue;
                    }
                    System.out.println("Enter name for previous number: ");
                    String name = scanner.nextLine();
                    phonebook.addNumber(name, p);
                } else if (entry == 2) {
                    City city = generateCity();
                    if (city == null) {
                        continue;
                    }
                    System.out.println("Enter a number in form \"111-111\"");
                    String number = scanner.nextLine();
                    PhoneNumber p = null;
                    try {
                        p = HomeTelephoneNumber.createNumber(city, number);
                    } catch (IllegalInputException e) {
                        System.out.println("Action not completed, try to enter valid arguments.");
                        continue;
                    }
                    System.out.println("Enter name for previous number: ");
                    String name = scanner.nextLine();
                    phonebook.addNumber(name, p);
                } else if (entry == 3) {
                    System.out.println("Enter country code ");
                    String country = scanner.nextLine();
                    System.out.println("Enter a number ");
                    String number = scanner.nextLine();
                    PhoneNumber p = null;
                    try {
                        p = InternationalPhoneNumber.createNumber(country, number);
                    } catch (IllegalInputException e) {
                        System.out.println("Action not completed, try to enter valid arguments.");
                        continue;
                    }
                    System.out.println("Enter name for previous number: ");
                    String name = scanner.nextLine();
                    phonebook.addNumber(name, p);
                }
            } else if (option == 2) {
                System.out.print("Press 1 if you want to get number for provided name\n" +
                        "Press 2 if you want to get all numbers from provided city\n" +
                        "Press 3 if you want to get all persons from provided city\n" +
                        "Press 4 if you want to search phonebook by starting letter\n");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    System.out.println(phonebook.getNumber(name));
                } else if (choice == 2) {
                    City city = generateCity();
                    Set<PhoneNumber> numbersFromGivenCity = phonebook.numbersFromCity(city);
                    System.out.println("Numbers from given city are:");
                    numbersFromGivenCity.forEach(m -> System.out.println(m.print()));
                } else if (choice == 3) {
                    City city = generateCity();
                    Set<String> personsFromGivenCity = phonebook.personsFromCity(city);
                    System.out.printf("Names from given city (%s) are:\n", city.name());
                    personsFromGivenCity.forEach(m -> System.out.println(m));
                } else if (choice == 4) {
                    System.out.println("Enter letter: ");
                    char startingLetter = scanner.nextLine().charAt(0);
                    System.out.println(phonebook.onThisLetter(startingLetter));
                } else {
                    System.out.println("Please choose option between 1 and 4");
                    continue;
                }
            } else {
                System.out.println("Please enter number 0,1 or 2");
            }

        } while (option != 0);

        System.out.println("Thank you for using our app");
    }

    public static City generateCity() {
        System.out.println("Enter city area code (030-039) ");
        String cityString = scanner.nextLine();

        switch (cityString) {
            case "030":
                return City.TRAVNIK;
            case "031":
                return City.ORASJE;
            case "032":
                return City.ZENICA;
            case "033":
                return City.SARAJEVO;
            case "034":
                return City.LIVNO;
            case "035":
                return City.TUZLA;
            case "036":
                return City.MOSTAR;
            case "037":
                return City.BIHAC;
            case "038":
                return City.GORAZDE;
            case "039":
                return City.SIROKI_BRIJEG;
            default:
                System.out.println("Area code is not valid - should be between 030 and 039");
                return null;
        }
    }
}