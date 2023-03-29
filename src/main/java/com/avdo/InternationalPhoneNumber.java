package com.avdo;

public class InternationalPhoneNumber extends PhoneNumber {

    private String country;

    public InternationalPhoneNumber(String country, String number) throws IllegalInputException {
        if (country != null && number != null) {
            this.number = number;
            this.country = country;
        } else
            throw new IllegalInputException("Please provide valid arguments");
    }

    public static PhoneNumber createNumber(String country, String number) throws IllegalInputException {
        PhoneNumber n = null;
        n = new InternationalPhoneNumber(country, number);
        return n;
    }

    @Override
    public String print() {
        return country + "/" + number;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return print().compareToIgnoreCase(phoneNumber.print());
    }

}
