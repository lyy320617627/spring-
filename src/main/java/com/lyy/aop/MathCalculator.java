package com.lyy.aop;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-17 09:54
 **/

public class MathCalculator {
    public int div(int i,int j){
        System.out.println("MathCalculator...div...");
        return i/j;

    }
}
