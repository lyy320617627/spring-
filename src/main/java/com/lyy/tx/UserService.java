package com.lyy.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-17 16:23
 **/
@Service
public class UserService {
    @Autowired
    private  UserDao userDao;
    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("插入完成....");
        int i=10/0;
    }

}
