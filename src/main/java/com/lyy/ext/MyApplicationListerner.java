package com.lyy.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-19 13:00
 **/
@Component
public class MyApplicationListerner implements ApplicationListener<ApplicationEvent> {
    //当容器中发布此事件以后，方法触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件"+event);
    }
}
