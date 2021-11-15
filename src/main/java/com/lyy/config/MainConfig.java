package com.lyy.config;

import com.lyy.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 16:37
 **/
//配置类就等于以前的配置文件
    @Configuration//告诉spring这是一个配置类
public class MainConfig {
    //给容器中注册一个Bean；类型；返回值的类型，id：默认是方法名作为返回类型
    @Bean("person01")
      public Person person(){
          return  new Person("lisi",20);
      }
}
