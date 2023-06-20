package org.avdo;

public class Person {
    private String id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;

    public Person(String id, String name, String surname, String phoneNumber, String city) {
        if ((name == null) || (surname == null) || (phoneNumber == null)) {
            throw new IllegalArgumentException("Name, surname and phone number must contain non-null values");
        }
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
