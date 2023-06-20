package org.example;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({"name", "age", "id", "height"})
public class Friend {
    @JsonIgnore
    private int height;

    private String name;
    @JsonProperty("weight") //meanwhile I changed field "id" to "weight" in .json file
    private int id;
    private int age;


    @JsonIgnore
    private Car car;

    public Friend() {}

    public Friend(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonGetter("weight")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
