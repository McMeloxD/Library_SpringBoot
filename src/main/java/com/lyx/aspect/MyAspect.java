package com.lyx.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
@Component //由Spring创建对象
@Aspect //让框架知道这是一个切面

public class MyAspect {

    /**
     *
     */
    // @Before("execution(* com.lyx.service.*.*(..))")
    // public void before(JoinPoint joinPoint) {
    //     System.out.println("方法执行前：权限效验");
    //     System.out.println(joinPoint.getSignature().getName());
    // }

    // @Around("execution(* com.lyx.service.*.*(..))")
    // public void before(ProceedingJoinPoint joinPoint) {
    //     System.out.println("方法执行前：事务开启");
    //     try {
    //         joinPoint.proceed();
    //     } catch (Throwable e) {
    //         e.printStackTrace();
    //         System.out.println("方法执行后：事务回滚");
    //         return;
    //     }
    //     System.out.println("方法执行后：事务提交");
    // }

    @AfterReturning(value ="execution(* com.lyx.service.*.*(..))",returning = "str")
    public void myAfterReturning(Object str) {
        System.out.println("后置返回，接受目标方法的返回值为：" + str);
    }
}
