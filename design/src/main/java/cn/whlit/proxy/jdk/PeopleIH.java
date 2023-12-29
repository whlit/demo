package cn.whlit.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author WangHaiLong 2023/4/28 17:15
 */
public class PeopleIH implements InvocationHandler {
    private People people;

    public PeopleIH(People people) {
        this.people = people;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(people, args);
    }
}
