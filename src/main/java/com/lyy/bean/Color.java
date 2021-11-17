package com.lyy.bean;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 20:28
 **/

public class Color {
       private   Car  car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
