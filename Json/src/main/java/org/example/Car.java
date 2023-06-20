package org.example;

public class Car {

    private String color;
    private int price;
    private int age;

    public Car(String color, int price, int age) {
        this.color = color;
        this.price = price;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
