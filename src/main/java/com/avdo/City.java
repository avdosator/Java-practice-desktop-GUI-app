package com.avdo;

public enum City {

    TRAVNIK("030"),
    ORASJE("031"),
    ZENICA("032"),
    SARAJEVO("033"),
    LIVNO("034"),
    TUZLA("035"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038"),
    SIROKI_BRIJEG("039");

    public String getAreaCode() {
        return areaCode;
    }

    private final String areaCode;

    City(String areaCode) {
        this.areaCode = areaCode;
    }
}
