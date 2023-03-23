package com.avdo;

public class MobilePhoneNumber extends PhoneNumber {
    private int provider;

    public MobilePhoneNumber(int provider, String number) throws IllegalInputException {
        if (provider > 60 && provider < 67 && number != null) {
            this.number = number;
            this.provider = provider;
        } else
            throw new IllegalInputException("Please provide valid arguments");

    }

    public String getNumber() {
        return number;
    }

    public static PhoneNumber createNumber(int provider, String number) throws IllegalInputException {
        PhoneNumber n = null;
        n = new MobilePhoneNumber(provider, number);


        return n;
    }
   /* public static MobilePhoneNumber factory (int provider, String number) {

        try {
            return new MobilePhoneNumber(provider,number);
        } catch (IllegalInputException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    @Override
    public String print() {
        return "0" + provider + "/" + number;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return print().compareToIgnoreCase(phoneNumber.print());
    }

}
