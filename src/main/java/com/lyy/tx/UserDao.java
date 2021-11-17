package com.lyy.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-17 16:23
 **/
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void insert(){
       String sql= "INSERT INTO `tbl_user`(username,age)VALUES(?,?)";
        String username = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,username,19);
    }
}
