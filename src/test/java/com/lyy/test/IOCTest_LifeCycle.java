package com.lyy.test;

import com.lyy.config.MainConfigOfLifeCycle;
import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-16 11:06
 **/

public class IOCTest_LifeCycle {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成....");
//        applicationContext.getBean("car");
        //关闭容器
        applicationContext.close();
    }
}
