package cn.whlit.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author WangHaiLong 2023/4/28 17:18
 */
public class Main {
    public static void main(String[] args) {
        ZhangSan zhangSan = new ZhangSan();
        PeopleIH people = new PeopleIH(zhangSan);
        People proxy = (People) Proxy.newProxyInstance(zhangSan.getClass().getClassLoader(), zhangSan.getClass().getInterfaces(), people);
        proxy.doSomething();
        System.out.println("exit");
    }
}
