package com.lyy.config;

import com.lyy.bean.Person;
import com.lyy.serrvice.BookService;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Type;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 16:37
 **/
//配置类就等于以前的配置文件
    @Configuration//告诉spring这是一个配置类
    @ComponentScans(
            value = {
                    @ComponentScan(value = "com.lyy",includeFilters = {
//                            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//                            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                            @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
                    },useDefaultFilters = false)

            }
    )

    //ComponentScan  value:指定要扫描的包,
    //excludeFilters=Filter[],指定扫描的时候按照什么规则排除那些
    //Filter[] includeFilters()：指定扫描的时候只包含那些组件
    //FilterType.ANNOTATION:按照注解
    //FilterType.ASSIGNABLE_TYPE:按照我们给定的类型过滤
    //FilterType.ASPECTJ:使用ASPECTJ表达式
    //FilterType.REGEX:使用正则表达式
    //FilterType.CUSTOM：使用自定义规则
public class MainConfig {
    //给容器中注册一个Bean；类型；返回值的类型，id：默认是方法名作为返回类型
    @Bean("person01")
      public Person person(){
          return  new Person("lisi",20,null);
      }
}
