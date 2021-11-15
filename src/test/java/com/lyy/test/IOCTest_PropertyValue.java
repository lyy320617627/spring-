package com.lyy.test;

import com.lyy.bean.Blue;
import com.lyy.bean.Person;
import com.lyy.config.MainConfig;
import com.lyy.config.MainConfig2;
import com.lyy.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 17:20
 **/

public class IOCTest_PropertyValue {
            AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
            @Test
    public void test01(){
                printBeans(applicationContext);
                System.out.println("====================");
                Person person = (Person) applicationContext.getBean("person");
                System.out.println(person);
                ConfigurableEnvironment environment = applicationContext.getEnvironment();
                String property = environment.getProperty("person.nickName");
                System.out.println(property);

                applicationContext.close();
            }
            private void printBeans(AnnotationConfigApplicationContext applicationContext){
                String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
                for (String beanDefinitionName : beanDefinitionNames) {
                    System.out.println(beanDefinitionName);

                }
            }
}
