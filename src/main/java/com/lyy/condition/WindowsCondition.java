package com.lyy.condition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.rmi.registry.Registry;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 19:58
 **/
//判断是否是windows系统
public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取到当前的环境
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        BeanDefinitionRegistry registry = context.getRegistry();
        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean person = registry.containsBeanDefinition("person");
        if (property.contains("Windows")){
            return true;
        }
        return false;
    }
}
