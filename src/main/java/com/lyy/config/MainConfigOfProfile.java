package com.lyy.config;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-16 19:09
 **/

import com.lyy.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 *
 *       Spring为我们提供的根据当前环境，动态的激活和切换一系列组件的功能；
 * @Profile：指定在那个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * 1)加了环境标识的bean，只有这个环境被激活的时候才能注册到容器当中，默认是default环境
 * 2)当加载到类上面时，只有指定的环境的时候，整个配置类里面的所有配置才能生效
 * 3）没有标注环境标识的bean在，任何环境下都是加载的
 *
 *
 *
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
    @Value("${db.user}")
    private String user;
    private StringValueResolver valueResolver;
    private String driverClass;
    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }
    @Profile("test")
    @Bean("testDataSource")
   public DataSource dataSource(@Value("${db.password}") String pwd) throws PropertyVetoException {
       ComboPooledDataSource dataSource = new ComboPooledDataSource();
       dataSource.setUser(user);
       dataSource.setPassword(pwd);
       dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test" );
       dataSource.setDriverClass("com.mysql.jdbc.Driver");
       return dataSource;
   }
   @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/scw_0515" );
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/scw_0515" );
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver=resolver;
        driverClass= valueResolver.resolveStringValue("${db.driverClass}");
    }
}
