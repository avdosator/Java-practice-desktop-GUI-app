package com.avdo;

public class InternationalPhoneNumber extends PhoneNumber {

    private String country;

    private InternationalPhoneNumber(String country, String number) {
            this.number = number;
            this.country = country;
    }

    public static PhoneNumber createNumber(String country, String number) throws IllegalInputException {
        return new InternationalPhoneNumber(country, number);
    }

    @Override
    public String getFormattedNumber() {
        return country + "/" + number;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return getFormattedNumber().compareToIgnoreCase(phoneNumber.getFormattedNumber());
    }

}
