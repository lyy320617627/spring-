package com.lyy.test;

import com.lyy.bean.Boss;
import com.lyy.config.MainConfigOfAutowired;
import com.lyy.config.MainConfigOfLifeCycle;
import com.lyy.dao.BookDao;
import com.lyy.serrvice.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-16 11:06
 **/

public class IOCTest_Autowired {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bean = applicationContext.getBean(BookService.class);
        System.out.println(bean);
//        BookDao bean1 = applicationContext.getBean(BookDao.class);
//        System.out.println(bean1);
        Boss bean1 = applicationContext.getBean(Boss.class);
        System.out.println("Boss得到的类型是"+bean1);
        applicationContext.close();
    }
}
