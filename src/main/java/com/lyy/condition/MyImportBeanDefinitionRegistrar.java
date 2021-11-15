package com.lyy.condition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 20:58
 **/

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{
    /**
     *
     * @param importingClassMetadata:当前类的注解信息
     * @param registry ：BeanDefinition注册类；
     *                 把所有需要添加到容器中的bean；
     *                 BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.lyy.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.lyy.bean.Blue");
        if (red && blue){
            //指定Bean定义信息（Bean的类型，Bean....）
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean，指定一个Bean名
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}
