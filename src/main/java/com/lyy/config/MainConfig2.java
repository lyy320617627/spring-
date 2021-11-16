package com.lyy.config;

import com.lyy.bean.Person;
import com.lyy.condition.LinuxCondition;
import com.lyy.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 19:08
 **/
/*//类中组件统一设置，满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional({WindowsCondition.class
})*/
@Configuration
public class MainConfig2 {
    /**
     * See Also:
     * ConfigurableBeanFactory.SCOPE_PROTOTYPE,prototype
     * ConfigurableBeanFactory.SCOPE_SINGLETON, singleton
     * org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST,request
     * org.springframework.web.context.WebApplicationContext.SCOPE_SESSION, session
     * value
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放到容器中，
     *                     每次获取的时候才会调用方法获取对象；每次获取都会调用一遍
     *
     * singleton：单实例的（默认值）:ioc容器启动会调用方法创建对象放到ioc容器中
     *            以后每次从容器中获取直接从容器中拿（map.get（）），
     * request:同一次请求
     * session：同一个session创建实例
     * 懒加载：
     *       单实例bean：默认在容器启动的时候创建对象；
     *       懒加载：容器启动不创建对象，第一次使用（获取）Bean创建对象，并初始化
     *       * @return
     */
//    @Scope("prototype")
     @Lazy
    @Bean("person")
    public Person person(){
    return new Person("张三",25);
    }
    /**
     * @Conditional({Conditional}):按照一定的条件进行判断，满足条件给容器中注册bean
     * 如果系统是windows，给容器中注册bill
     * 如果是linux系统，给容器中注册linus
     */
    @Conditional({WindowsCondition.class
    })
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }
    @Conditional({LinuxCondition.class
    })
    @Bean("linus")
    public Person person02(){
      return new Person("linus",48);
    }
}
