package org.avdo.patterns.adapter;

public class Person {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;

    public Person(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        String person = "Name: " + getFirstName() + " " + getLastName() + "\n" + "Email: " + getEmail() + "\n"
                + "Phone number: " + getPhoneNumber();
        return person;
    }
}
