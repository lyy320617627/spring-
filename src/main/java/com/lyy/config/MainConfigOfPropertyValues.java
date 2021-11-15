package com.lyy.config;

import com.lyy.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-16 14:28
 **/
//使用@Properties读取外部配置文件中的属性k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件中的值
@PropertySource(value = {"classpath:/person.properties"},encoding = "utf-8")
@Configuration
public class MainConfigOfPropertyValues {
    @Bean
    public Person person(){
        return new Person();
    }
}
