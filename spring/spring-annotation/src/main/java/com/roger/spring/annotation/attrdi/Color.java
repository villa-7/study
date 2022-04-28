package com.roger.spring.annotation.attrdi;

public class Color {

    public Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color [car=" + car + "]";
    }

}
