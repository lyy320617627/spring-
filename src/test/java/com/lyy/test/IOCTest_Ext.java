package com.lyy.test;


import com.lyy.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 17:20
 **/

public class IOCTest_Ext {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        //我发布了一个事件
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });
    applicationContext.close();
    }
}
