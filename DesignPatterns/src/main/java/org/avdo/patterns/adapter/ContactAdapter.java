package org.avdo.patterns.adapter;

public class ContactAdapter implements Contact {

    Person person;

    public ContactAdapter(Person person) {
        this.person = person;
    }

    @Override
    public String getName() {
        return person.getFirstName() + " " + person.getLastName();
    }

    @Override
    public String getEmail() {
        return person.getEmail();
    }

    @Override
    public String getPhoneNumber() {
        return person.getPhoneNumber();
    }

    @Override
    public String toString() {
        String contact = "Name: " + getName() + "\n" + "Email: " + getEmail() + "\n" + "Phone number: " + getPhoneNumber();
        return contact;
    }
}
