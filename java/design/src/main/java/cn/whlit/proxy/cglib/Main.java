package cn.whlit.proxy.cglib;

/**
 * @author WangHaiLong 2023/4/28 19:14
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Subject proxy = ProxyFactory.createProxy(subject.getClass(), new MyCallback());
        proxy.doSomething();
    }
}
