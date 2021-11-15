package com.lyy.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-16 11:36
 **/
@Component
public class Dog {
    private ApplicationContext applicationContext;
    public Dog(){
        System.out.println("dog constructor......");
    }
    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog......@PostConstruct......");
    }
    //容器移除对象之前
    @PreDestroy
    public void destroy(){
        System.out.println("Dog... @PreDestroy...");
    }
}
