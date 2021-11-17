package com.lyy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-17 09:57
 * @Aspect:告诉Spring当前类是一个切面类，而不是其他普通的类
 **/
@Aspect
public class LogAspects {
    //抽取公共的切入点表达式：
    //1.本类引用
    //2.其他的切面引用
    @Pointcut("execution(public int com.lyy.aop.MathCalculator.*(..))")
    public void pointCut(){
    };
    //@Before在目标方法切入之前切入：切入点表达式：public int com.lyy.aop.MathCalculator.div
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"运行...参数列表是：{"+ Arrays.toString(args) +"}");
    }
    //JoinPointy一定要出现在参数表的第一位
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"法结束");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("除法正返回...运行结果"+result+"");
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法异常...异常信息{}");
    }
}
