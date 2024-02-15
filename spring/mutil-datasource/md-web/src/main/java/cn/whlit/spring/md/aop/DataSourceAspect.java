package cn.whlit.spring.md.aop;

import cn.whlit.spring.md.config.DataSourceHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangHaiLong 2024/2/15 21:40
 */
@Aspect
@Configuration
public class DataSourceAspect {

    //设置aop的切入点，在controller层就设置
    @Pointcut("execution(* cn.whlit.spring.md.web..*.*(..))")
    public void dataSourcePointcut(){

    }

    @Before("dataSourcePointcut()")
    public void before(){
        //切换数据源，条件可以从用户的登录信息，或者是从入参传入等方式进行数据源的切换，也可以不在aop中进行设置数据源
        DataSourceHolder.setDataSource("test");
    }

    @After("dataSourcePointcut()")
    public void after(){
        //执行完成时清除数据源
        DataSourceHolder.removeDataSource();
    }
}
