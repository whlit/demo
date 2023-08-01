package cn.whlit.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author WangHaiLong 2023/4/28 19:11
 */
public class ProxyFactory {
    public static <T> T createProxy(Class<T> c, Callback callback){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c);
        enhancer.setCallback(callback);
        return (T) enhancer.create();
    }
}
