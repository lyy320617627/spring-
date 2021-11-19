package com.lyy.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-19 13:33
 **/
@Service
public class UserService {
    @EventListener(classes = ApplicationEvent.class)
    public void listen(ApplicationEvent event){
        System.out.println("UserService...监听1到的是事件"+event);
    }
}
