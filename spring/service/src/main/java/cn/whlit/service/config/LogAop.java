package cn.whlit.service.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author WangHaiLong 2024/7/10 22:13
 */
@Aspect
@Configuration
public class LogAop {

    @Pointcut("execution(* cn.whlit.service..*.*(..))")
    public void servicePointcut(){}

    @Before("servicePointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("访问接口：" + joinPoint.getSignature().toString());
    }
}
