package com.avdo;

import lombok.Getter;

@Getter
public class HomeTelephoneNumber extends PhoneNumber {
    private final String areaCode;

    public HomeTelephoneNumber(City city, String number) throws IllegalInputException {
        if (number != null && city != null) {
            this.number = number;
            this.areaCode = city.getAreaCode();
        } else
            throw new IllegalInputException("Please provide valid arguments");
    }

    public static PhoneNumber createNumber(City city, String number) throws IllegalInputException {
        PhoneNumber n = null;
        n = new HomeTelephoneNumber(city, number);
        return n;
    }

    public String print() {
        return areaCode + "/" + number;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return print().compareToIgnoreCase(phoneNumber.print());
    }

}
