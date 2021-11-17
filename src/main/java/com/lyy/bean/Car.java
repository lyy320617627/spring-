package com.lyy.bean;

import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-16 11:03
 **/
@Component
public class Car {
    public Car(){
        System.out.println("car constructor...");
    }
    public void init(){
        System.out.println("car...init");
    }
    public void destory(){
        System.out.println("car...destory...");
    }
}
