package com.avdo;

import java.util.Scanner;
import java.util.Set;

public class Program {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();
        System.out.println("**Welcome to  phonebook app**");
        int option;

        do {
            System.out.println();
            askUserForOption();
            option = scanner.nextInt();
            if (option == 0) {
                break;
            } else if (option == 1) {
                askUserForAddingSuboption();
                int chosenSuboption = scanner.nextInt();
                scanner.nextLine();
                if (chosenSuboption == 1) {
                    PhoneNumber phoneNumber;
                    try {
                        phoneNumber = takeInfoAndCreateMobilePhoneNumber();
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    String name = takeNameFromUser();
                    if (isEmptyString(name)) {
                        continue;
                    }
                    addPhoneNumberToPhonebook(phonebook, phoneNumber, name);
                } else if (chosenSuboption == 2) {
                    PhoneNumber phoneNumber;
                    try {
                        phoneNumber = takeInfoAndCreateHomeTelephoneNumber();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    String name = takeNameFromUser();
                    if (isEmptyString(name)) {
                        continue;
                    }
                    addPhoneNumberToPhonebook(phonebook, phoneNumber, name);
                } else if (chosenSuboption == 3) {
                    PhoneNumber phoneNumber;
                    try {
                        phoneNumber = takeInfoAndCreateInternationalPhoneNumber();
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    String name = takeNameFromUser();
                    if (isEmptyString(name)) {
                        continue;
                    }
                    addPhoneNumberToPhonebook(phonebook, phoneNumber, name);
                } else {
                    System.out.println("Please choose valid option");
                }
            } else if (option == 2) {
                takeUsersSearchingOption();
                int chosenSearchingOption = scanner.nextInt();
                scanner.nextLine();
                switch (chosenSearchingOption) {
                    case 1 -> searchByName(phonebook);
                    case 2 -> getNumbersFromCity(phonebook);
                    case 3 -> getNamesFromCity(phonebook);
                    case 4 -> getEntriesOnProvidedLetter(phonebook);
                    default -> System.out.println("Please choose valid option");
                }
            } else {
                System.out.println("Please choose valid option");
            }
        } while (option != 0);

        System.out.println("Thank you for using our app");
        scanner.close();
    }

    private static void addPhoneNumberToPhonebook(Phonebook phonebook, PhoneNumber phoneNumber, String name) {
        try {
            phonebook.addNumber(phoneNumber, name);
            System.out.println("You have successfully added a contact");
        } catch (IllegalInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getEntriesOnProvidedLetter(Phonebook phonebook) {
        System.out.println("Enter letter: ");
        String userInput = scanner.nextLine().trim();
        char startingLetter;
        if (!userInput.isEmpty()) {
            startingLetter = userInput.charAt(0);
            System.out.printf("Entries starting with %c are:\n", startingLetter);
            System.out.println(phonebook.onThisLetter(startingLetter));
        } else {
            System.out.println("You have not entered a letter, please try again");
        }
    }

    private static void getNamesFromCity(Phonebook phonebook) {
        City city = generateCityFromUsersInput();
        Set<String> personsFromGivenCity;
        try {
            personsFromGivenCity = phonebook.personsFromCity(city);
        } catch (IllegalInputException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.printf("Names from %s are:\n", city.name());
        if (personsFromGivenCity != null) {
            personsFromGivenCity.forEach(m -> System.out.println(m));
        }
    }

    private static void getNumbersFromCity(Phonebook phonebook) {
        City city = generateCityFromUsersInput();
        Set<PhoneNumber> numbersFromGivenCity;
        try {
            numbersFromGivenCity = phonebook.numbersFromCity(city);
        } catch (IllegalInputException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.printf("Numbers from %s are:\n", city.name());
        numbersFromGivenCity.forEach(m -> System.out.println(m.getFormattedNumber()));
    }

    private static void searchByName(Phonebook phonebook) {
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println(phonebook.getNumber(name));
    }

    private static void takeUsersSearchingOption() {
        System.out.print("Press 1 if you want to get number for provided name\n" +
                "Press 2 if you want to get all numbers from provided city\n" +
                "Press 3 if you want to get all persons from provided city\n" +
                "Press 4 if you want to search phonebook by starting letter:\n");
    }

    private static PhoneNumber takeInfoAndCreateInternationalPhoneNumber() throws IllegalInputException {
        System.out.println("Enter country code ");
        String country = scanner.nextLine().trim();
        System.out.println("Enter a number ");
        String number = scanner.nextLine().trim();
        if (number.isEmpty() || country.isEmpty()) {
            throw new IllegalInputException("Please enter country and number strings");
        }
        PhoneNumber phoneNumber;
        try {
            phoneNumber = InternationalPhoneNumber.createNumber(country, number);
        } catch (IllegalInputException e) {
            System.out.println("Action not completed, try to enter valid arguments.");
            return null;
        }
        return phoneNumber;
    }

    private static PhoneNumber takeInfoAndCreateHomeTelephoneNumber() throws IllegalInputException {
        City city = generateCityFromUsersInput();
        if (city == null) {
            throw new IllegalInputException("Please provide valid city");
        }
        System.out.println("Enter a number in form \"111-111\"");
        String number = scanner.nextLine().trim();
        if (number.isEmpty()) {
            throw new IllegalInputException("Please provide number in form \"111-111\"");
        }
        return HomeTelephoneNumber.createNumber(city, number);
    }

    private static PhoneNumber takeInfoAndCreateMobilePhoneNumber() throws IllegalInputException {
        System.out.println("Enter a provider (60-67)");
        int provider = scanner.nextInt();
        scanner.nextLine();
        if (provider < 60 || provider > 67) {
            throw new IllegalInputException("Provider not valid, please choose valid provider");
        }
        System.out.println("Enter a number in form \"111-111\"");
        String number = scanner.nextLine().trim();
        if (number.isEmpty()) {
            throw new IllegalInputException("Please provide number in form \"111-111\"");
        }
        return MobilePhoneNumber.createNumber(provider, number);
    }

    private static void askUserForAddingSuboption() {
        System.out.println("Choose an option:");
        System.out.print("Press \"1\" if you want to add mobile number\n" +
                "Press \"2\" if you want to add home phone number\n" +
                "Press \"3\" if you want to add international phone number:\n");
    }

    private static void askUserForOption() {
        System.out.print("Press \"1\" if you want to add new entry\n" +
                "Press \"2\" if you want to use some searching options\n" +
                "Press \"0\" if you want to exit:\n");
    }

    private static City generateCityFromUsersInput() { // maybe use Optional<City>
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

    private static String takeNameFromUser() {
        System.out.println("Enter name for previous number: ");
        return scanner.nextLine().trim();
    }

    private static boolean isEmptyString(String name) {
        if (name.isEmpty()) {
            System.out.println("Creation is not completed, please enter a name after number");
            return true;
        }
        return false;
    }
}