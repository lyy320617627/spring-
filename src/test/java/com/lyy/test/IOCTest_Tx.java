package com.lyy.test;

import com.lyy.tx.TxConfig;
import com.lyy.tx.UserDao;
import com.lyy.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-17 16:32
 **/

public class IOCTest_Tx {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
        applicationContext.close();

    }
}
