package com.lyy.test;

import com.lyy.bean.Person;
import com.lyy.config.MainConfig;
import com.lyy.config.MainConfig2;
import com.sun.deploy.panel.ITreeNode;
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

public class IOCTest {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void testImport(){
        printBeans(annotationConfigApplicationContext);
    }
    private void printBeans( AnnotationConfigApplicationContext annotationConfigApplicationContext){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);

        }
    }
    @Test
    public void test03(){
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        //获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        Map<String, Person> persons = annotationConfigApplicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }





     @SuppressWarnings("resource")
     @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }
    @Test
    public void test02(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("ioc容器创建对象......");
        Object person = annotationConfigApplicationContext.getBean("person");
//        Object person1 = annotationConfigApplicationContext.getBean("person");
//        System.out.println(person1==person);
    }
}
