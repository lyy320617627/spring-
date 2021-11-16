package com.lyy.config;

import com.lyy.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-16 15:06
 **/

/**
 * 自动装配：
 * Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系赋值；
 * 1)Autowired:自动注入，
 * 1).默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class);
 * 2)如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找    application.getBean（"bookDao"）
 * 3） @Qualifier("bookDao")可以指定装配的id
 * 4）自动装配 默认一定要将属性赋值好，没有就会报错
 *5) @Autowired(required = false)可以使用required=false；不必将属性赋值好
 * 6）@Primary：让Spring进行自动装配的时候，默认使用首选的bean
 *      也可以继续使用@Qualifier指定需要装配的bean的名字
 * 2.Spring还支持使用@Resource（JSR250）和@Inject（JSR330）的规范【java规范的注解】
 *     @Resource：
 *     可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的
 *     没有能支持@Primary功能没有支持@Autowired(required=false);
 * @Inject:
 *        需要导入javax.Inject的包，和Autowired的功能一样，没有required=false的功能；
 *        AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能
 *
 *
 * BookService {
 * @Autowired
 *     BookDao bookDao;
 * }
 */
@Configuration
@ComponentScan({"com.lyy.serrvice","com.lyy.dao","com.lyy.controller"})
public class MainConfigOfAutowired {
    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return new BookDao();
    }
}
