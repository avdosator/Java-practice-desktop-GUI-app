package com.avdo;

import java.util.*;

public class Phonebook {
    Map<String, PhoneNumber> phonebook = new HashMap<>();    // should PhoneNumber be a key and name a value, because key is unique?

    public void addNumber(String name, PhoneNumber number) {
        if (number != null)
            phonebook.putIfAbsent(name, number);
    }

    public String getNumber(String name) {
        PhoneNumber number = null;
        if (phonebook.containsKey(name)) {
            number = phonebook.get(name);
            return number.print();
        }

        return null;
    }

    public String getName(PhoneNumber number) {
        if (phonebook.containsValue(number)) {
            for (Map.Entry<String, PhoneNumber> entry : phonebook.entrySet()) {
                String s1 = entry.getValue().print();
                if (number.print().equals(s1)) {
                    return entry.getKey();
                }
            }
        }

        return "There is no anybody with that number in phonebook";
    }

    public String onThisLetter(char c) {
        StringBuilder entries = new StringBuilder();
        List<String> matchingEntries = new ArrayList<>();
        for (Map.Entry<String, PhoneNumber> entry : phonebook.entrySet()) {
            String name = entry.getKey();
            if (c == name.charAt(0)) {
                entries.append(name + " - " + entry.getValue().print()).append("\n");
            }
        }
        return entries.toString();
    }

    public Set<String> personsFromCity(City city) {
        Set<String> namesFromGivenCity = new TreeSet<>();
        for (Map.Entry<String, PhoneNumber> entry : phonebook.entrySet()) {
            PhoneNumber p = entry.getValue();
            if (p instanceof HomeTelephoneNumber) {
                if (((HomeTelephoneNumber) p).getAreaCode().equals(city.getAreaCode()))    // this seems to be ugly...
                    namesFromGivenCity.add(entry.getKey());
            }
        }
        return namesFromGivenCity;
    }

    public Set<PhoneNumber> numbersFromCity(City city) {
        Set<PhoneNumber> numbersFromGivenCity = new TreeSet<>();
        for (Map.Entry<String, PhoneNumber> entry : phonebook.entrySet()) {
            PhoneNumber p = entry.getValue();
            if (p instanceof HomeTelephoneNumber) {
                if (((HomeTelephoneNumber) p).getAreaCode().equals(city.getAreaCode()))    // this seems to be ugly...
                    numbersFromGivenCity.add(entry.getValue());
            }
        }
        return numbersFromGivenCity;
    }

}
