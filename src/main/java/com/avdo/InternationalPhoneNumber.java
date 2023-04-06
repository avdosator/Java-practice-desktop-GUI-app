package com.avdo;

public class InternationalPhoneNumber extends PhoneNumber {

    private String country;

    InternationalPhoneNumber(String country, String number) throws IllegalInputException {
        if (country != null && number != null) {
            this.number = number;
            this.country = country;
        } else {
            throw new IllegalInputException("Please provide valid arguments");
        }
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
