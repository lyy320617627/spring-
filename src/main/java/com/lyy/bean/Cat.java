package com.lyy.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-16 11:26
 **/
@ComponentScan("com.lyy")
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("cat......constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destory...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }
}
