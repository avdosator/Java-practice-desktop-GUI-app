package org.avdo.patterns.observer;

public class WeatherStation extends Subject {

    public void changeState(int temperature, int humidity) {

        this.setTemperature(temperature);
        this.setHumidity(humidity);
        this.notifyObservers();

    }
}
