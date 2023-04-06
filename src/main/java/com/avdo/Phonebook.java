package com.avdo;

import java.util.*;

public class Phonebook {
    private Map<PhoneNumber, String> phonebook = new HashMap<>();

    public void addNumber(PhoneNumber number, String name) throws IllegalInputException {
        if (number != null || name != null) {
            phonebook.putIfAbsent(number, name);
        } else {
            throw new IllegalInputException("Please provide valid arguments");
        }
    }

    public Optional<String> getNumber(String name) {
        if (phonebook.containsValue(name)) {
            for (Map.Entry<PhoneNumber, String> entry : phonebook.entrySet()) {
                final String entryKey = entry.getKey().getFormattedNumber();
                if (name.equals(entry.getValue())) {
                    return Optional.of(entryKey);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<String> getName(PhoneNumber number) {
        String name = null;
        if (phonebook.containsKey(number)) {
            for (Map.Entry<PhoneNumber, String> entry : phonebook.entrySet()) {
                name = entry.getValue();
                if (number.equals(entry.getKey())) {
                    return Optional.of(name);
                }
            }
        }
        return Optional.empty();
    }

    public int getPhonebookSize() {
        return phonebook.size();
    }

    public String onThisLetter(char c) {
        StringBuilder entries = new StringBuilder();
        for (Map.Entry<PhoneNumber, String> entry : phonebook.entrySet()) {
            String name = entry.getValue();
            if (c == name.charAt(0)) {
                entries.append(name + " - " + entry.getKey().getFormattedNumber()).append("\n");
            }
        }
        return entries.toString();
    }

    public Set<String> personsFromCity(City city) throws IllegalInputException {
        Set<String> namesFromGivenCity = new TreeSet<>();
        if (city != null) {
            for (Map.Entry<PhoneNumber, String> entry : phonebook.entrySet()) {
                PhoneNumber phoneNumber = entry.getKey();
                if (phoneNumber instanceof HomeTelephoneNumber) {
                    String entryAreaCode = ((HomeTelephoneNumber) phoneNumber).getAreaCode();
                    if (entryAreaCode.equals(city.getAreaCode())) {
                        namesFromGivenCity.add(entry.getValue());
                    }
                }
            }
        } else {
            throw new IllegalInputException("Provided city is not valid");
        }
        return namesFromGivenCity;
    }

    public Set<PhoneNumber> numbersFromCity(City city) throws IllegalInputException {
        Set<PhoneNumber> numbersFromGivenCity = new TreeSet<>();
        if (city != null) {
            for (Map.Entry<PhoneNumber, String> entry : phonebook.entrySet()) {
                PhoneNumber phoneNumber = entry.getKey();
                if (phoneNumber instanceof HomeTelephoneNumber) {
                    String entryAreaCode = ((HomeTelephoneNumber) phoneNumber).getAreaCode();
                    if (entryAreaCode.equals(city.getAreaCode())) {
                        numbersFromGivenCity.add(entry.getKey());
                    }
                }
            }
        } else {
            throw new IllegalInputException("Please provide valid city");
        }
        return numbersFromGivenCity;
    }
}
