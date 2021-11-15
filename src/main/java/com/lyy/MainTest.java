package com.lyy;

import com.lyy.bean.Person;
import com.lyy.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 16:33
 **/

public class MainTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        Person bean = (Person) applicationContext.getBean("person");
//        System.out.println(bean);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : namesForType) {
            System.out.println(s);
        }
    }
}
