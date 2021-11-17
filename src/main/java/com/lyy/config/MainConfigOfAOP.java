package com.lyy.config;

import com.lyy.aop.LogAspects;
import com.lyy.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**2
 * @program: spring-annotation
 * @description:AOP【动态代理】
 *              指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *              1.导入AOP的模块：SPringAOP：(spring-aspects)
 *              2.定义一个业务逻辑类（MathCalculator）；在业务逻辑运行的时候将日志进行打印（方法之前、方法运行结束、方法出现异常、xxx）
 *              3.定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知MathCalculator.div运行到哪一步了然后执行
 *              通知方法：
 *                  前置通知（@Before）：logStart：在目标方法（div）运行之前运行
 *                  后置通知（@After）：logEnd：：在目标方法（div）运行结束之后运行(无论方法是正常结束还是异常结束，都会调用)
 *                  返回通知（@AfterReturing）：logReturn：在目标方法（div）正常返回之后运行
 *                  异常通知（@AfterThrowing）：logException：在目标方法（div）出现异常以后运行
 *                  环绕通知（@Around）：动态代理，手动推进目标方法运行（joinPoint.procced）
 *          4：给切面类的目标方法标注何时何地运行（通知注解）
 *          5：将切面类和业务逻辑类（目标方法所在类）都加入到容器中；
 *          6:必须告诉Spring那个类是切面类（给切面类上加一个注解）
 *          7:给配置类中加一个@EnableAspectJAutoProxy 【开启基于注解的aop模式】
 *          8：在Spring中很多的@EnableXXX：
 *          三步：
 *          1）将业务逻辑组件和切面类都加入到容器中，告诉Spring组件那个是切面类（@Aspect）
 *          2）在切面类上每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 *          3）开启基于注解的aop模式：@EnableAspectJAutoProxy
 *AOP原理：【看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能是什么】
 * @EnableAspectJAutoProxy：
 * 1.@Import(AspectJAutoProxyRegistrar.class)：给容器中导入@EnableAspectJAutoProxy
 *          利用AspectJAutoProxyRegistrar自定义给容器中注册bean，
 *
 *
 *
 *
 * @author: ly
 * @create: 2021-11-17 09:49
 **/
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
    //将业务逻辑类加入到容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }
    //将切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
