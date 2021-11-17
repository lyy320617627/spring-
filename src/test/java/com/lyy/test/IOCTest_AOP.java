package com.lyy.test;


import com.lyy.aop.MathCalculator;
import com.lyy.config.MainConfigOfAOP;
import com.lyy.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 17:20
 **/

public class IOCTest_AOP {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        //1.不要自己创建对象
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        int div = bean.div(1, 1);
        System.out.println(div);
        applicationContext.close();


    }
}
