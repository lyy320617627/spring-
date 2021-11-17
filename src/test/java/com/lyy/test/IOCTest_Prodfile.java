package com.lyy.test;


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

public class IOCTest_Prodfile {
    //1使用命令行动态参数的形式，在虚拟机参数位置加载-Dspring.profiles.active=test

    @Test
     public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);

        }
        applicationContext.close();
    }
    //2.使用命令行的形式
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1.创建一个applicationContext
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        //3.注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //刷新
        applicationContext.refresh();
        String[] names = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : names) {
            System.out.println(name);

        }

    }
}
