package org.avdo.patterns.observer;

public class ObserverDemo {

    public static void main(String[] args) {
        Subject subject = new WeatherStation();
        Observer observer = new WeatherDisplay(subject);
        subject.changeState(10, 10);
        subject.changeState(20, 20);
        Observer observer1 = new WeatherDisplay(new WeatherStation());
        subject.changeState(30, 30);


    }
}
