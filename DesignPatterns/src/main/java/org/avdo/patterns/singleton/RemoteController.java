package org.avdo.patterns.singleton;

public class RemoteController {

    private TV tv;

    private RemoteController() {}

    public void setTv(TV tv) {
        this.tv = tv;
    }

    private static class RemoteControllerHolder {
        static final RemoteController instance = new RemoteController();
    }

    public static RemoteController getInstance() {
        return RemoteControllerHolder.instance;
    }

    public void turnOnTv() {
        tv.turnOn();
    }

    public void turnOfTv() {
        tv.turnOff();
    }

    public void increaseVolume() {
        tv.increaseVolume();
    }

    public void decreaseVolume() {
        tv.decreaseVolume();
    }

}
