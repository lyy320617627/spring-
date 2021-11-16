package com.lyy.dao;

import org.springframework.stereotype.Repository;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 17:18
 **/
//名字默认是首字母小写
@Repository
public class BookDao {
   private String lable="1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
