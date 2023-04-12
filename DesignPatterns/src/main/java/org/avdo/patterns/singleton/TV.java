package org.avdo.patterns.singleton;

public class TV {

    private final String manufacturer;
    private int volume;
    private boolean isOn;

    public TV(String manufacturer) {
        this.manufacturer = manufacturer;

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Tv is turned on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("TV is turned off");
    }

    public void increaseVolume() {
        volume = volume + 1;
        System.out.println("volume is " + volume);
    }

    public void decreaseVolume() {
        volume = volume - 1;
        System.out.println("volume is " + volume);
    }
}
