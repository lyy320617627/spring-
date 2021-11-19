package com.lyy.ext;

import com.lyy.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-annotation
 *   BeanPostProcessor:bean后置处理器，bean创建对象初始化前后进行拦截工作的
 * @description:BeanFactoryPostProcessor:beanFactory的后置处理器：
 *   在BeanFactory标准初始化之后调用，所有的bean定义已经保存加载，但是bean的实例还未创建
 *   1)ioc容器创建对象
 *   2）invokeBeanFactoryPostProcessors（beanFactory）：执行BeanFactoryPostProcessor；
 *      如何找到所有的BeanFactoryPostProcessor并执行他们的方法：
 *      1）直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *      2）在初始化创建其他组件前面执行
 *3） BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *    postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry):
 *    在所有的bean定义信息将被加载，bean实例还未创建的时候
 *4)
 * ApplicationListener:箭筒容器中发布的事件，事件驱动开发；
 *   public interface ApplicationListener<E extends ApplicationEvent>:
 *   监听ApplicationEvent及其下面的子事件
 *  步骤：
 *  1.写一个监听器来监听某个事件（ApplicationEvent及其子类）
 *  2.把监听器加入到容器中
 *  3.只要容器中有相关事件的发布，我们就能监听到这个事件
 *              ContextRefreshedEvnet，容器刷新完成（所有的bean都完全创建）会发布这个事件
 *              ContextClosedEvent：关闭容器会发布这个事件
 * 5）发布一个事件
 *       applicationContext.publishEvent
 *       原理：1.ContextRefreshedEven事件：
 *       2.容器创建对象，refresh（）工作
 *
 *
 *
 * @author: ly
 * @create: 2021-11-17 19:07
 **/
@ComponentScan("com.lyy.ext")
@Configuration
public class ExtConfig {
    @Bean
   public Blue blue(){
       return new Blue();
   }
}
