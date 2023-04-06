package com.avdo;

public class MobilePhoneNumber extends PhoneNumber {
    private int provider;

    private MobilePhoneNumber(int provider, String number) throws IllegalInputException {
        if ((provider > 60 && provider < 67) && number != null) {
            this.number = number;
            this.provider = provider;
        } else {
            throw new IllegalInputException("Please provide valid arguments");
        }
    }

    public String getNumber() {
        return number;
    }

    public static PhoneNumber createNumber(int provider, String number) throws IllegalInputException {
        return new MobilePhoneNumber(provider, number);
    }

    @Override
    public String getFormattedNumber() {
        return "0" + provider + "/" + number;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return getFormattedNumber().compareToIgnoreCase(phoneNumber.getFormattedNumber());
    }

}
