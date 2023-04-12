package org.avdo.patterns.singleton;

public class Main {
    public static void main(String[] args) {

        TV tv = new TV("Samsung");
        RemoteController remoteController = RemoteController.getInstance();

        remoteController.setTv(tv);
        remoteController.turnOnTv();

        for (int i = 0; i < 10; i++) {
            remoteController.increaseVolume();
        }
        remoteController.decreaseVolume();
        remoteController.turnOfTv();

    }
}