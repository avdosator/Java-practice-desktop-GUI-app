package com.avdo;

import lombok.Getter;

@Getter
public class HomeTelephoneNumber extends PhoneNumber {
    private final String areaCode;

    private HomeTelephoneNumber(City city, String number) throws IllegalInputException {
        if (city != null && number != null) {
            this.number = number;
            this.areaCode = city.getAreaCode();
        } else {
            throw new IllegalInputException("Please provide valid arguments");
        }
    }

    public static PhoneNumber createNumber(City city, String number) throws IllegalInputException {
        return new HomeTelephoneNumber(city, number);
    }

    public String getFormattedNumber() {
        return areaCode + "/" + number;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return getFormattedNumber().compareToIgnoreCase(phoneNumber.getFormattedNumber());
    }

}
