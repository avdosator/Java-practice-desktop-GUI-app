package org.avdo.patterns.observer;

public class WeatherDisplay extends Observer {

    public WeatherDisplay(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Temperature is now " + subject.getTemperature() + " , and humidity is " + subject.getHumidity());
    }
}
