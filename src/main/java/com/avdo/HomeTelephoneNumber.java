package com.avdo;

import lombok.Getter;

@Getter
public class HomeTelephoneNumber extends PhoneNumber {
    private final String areaCode;

    private HomeTelephoneNumber(City city, String number) {
            this.number = number;
            this.areaCode = city.getAreaCode();
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
