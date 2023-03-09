package com.avdo;

import java.util.Map;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        PhoneNumber p = null;
        PhoneNumber p1 = null;
        PhoneNumber p2 = null;
        PhoneNumber p3 = null;
        PhoneNumber p4 = null;
        PhoneNumber p5 = null;
        PhoneNumber p6 = null;
        PhoneNumber p7 = null;
        PhoneNumber p8 = null;
        PhoneNumber s = MobilePhoneNumber.createNumber(62, null); // does something like this make sense?
        createInstance(p1, 62, null); // or something like this...
        PhoneNumber s1 = MobilePhoneNumber.createNumber(62, "111-111");


        try {
            p = new MobilePhoneNumber(62, "183-628");
            p2 = new MobilePhoneNumber(62, "014-936");
            p3 = new MobilePhoneNumber(63, "852-949");
            p4 = new MobilePhoneNumber(62, "364-375");
            p5 = new MobilePhoneNumber(61, "917-366");
            p6 = new HomeTelephoneNumber(City.SARAJEVO, "481-213");
            p7 = new InternationalPhoneNumber("+550", "111-222-333");
            p8 = new HomeTelephoneNumber(City.SARAJEVO, "481-214");
        } catch (IllegalInputException e) {
            e.printStackTrace();
        }

        Phonebook phones = new Phonebook();
        phones.addNumber("Avdo", p);

        phones.addNumber("Vedo", p1);
        phones.addNumber("Proba", s);
        phones.addNumber("Proba", s1);

        phones.addNumber("Shata", p2);
        phones.addNumber("Mama", p3);
        phones.addNumber("Zlaja", p4);
        phones.addNumber("Klapa", p5);
        phones.addNumber("Sator", p6);
        phones.addNumber("Cako", p7);
        phones.addNumber("Mulic", p8);

        System.out.print("Klapa's number is: ");
        System.out.println(phones.getNumber("Klapa"));

        System.out.println("All numbers from phonebook are: ");
        for (Map.Entry<String, PhoneNumber> entry : phones.phonebook.entrySet())
            System.out.printf("%-10s - %s\n", entry.getKey(), entry.getValue().print());

        System.out.println(phones.getName(p5));

        System.out.println("All entries starting with \"M\": ");
        String matchingNumbers = phones.onThisLetter('M');
        //for (String s1: matchingNumbers)
        System.out.println(matchingNumbers);
        City sarajevo = City.SARAJEVO;
        Set<String> personsFromGivenCity = phones.personsFromCity(City.SARAJEVO);
        System.out.printf("Names from given city (%s) are:\n", sarajevo.name());
        personsFromGivenCity.forEach(m -> System.out.println(m));

        Set<PhoneNumber> numbersFromGivenCity = phones.numbersFromCity(City.SARAJEVO);
        System.out.println("Numbers from given city are:");
        numbersFromGivenCity.forEach(m -> System.out.println(m.print()));

    }


    public static void createInstance(PhoneNumber phoneNumber, int provider, String number) {
        try {
            phoneNumber = new MobilePhoneNumber(provider, number);
        } catch (IllegalInputException e) {
            e.printStackTrace();
        }
    }
}