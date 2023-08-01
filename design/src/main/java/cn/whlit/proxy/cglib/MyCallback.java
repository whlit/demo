package cn.whlit.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author WangHaiLong 2023/4/28 19:09
 */
public class MyCallback implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("增强方法开始");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("原有方法执行完成");
        System.out.println("增强方法结束");
        return result;
    }
}
