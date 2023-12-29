package cn.whlit;


import cn.whlit.classloader.MyClassLoader;

import java.lang.reflect.Method;
import java.nio.file.Path;

/**
 * @author WangHaiLong 2023/8/5 18:52
 */
public class Main {
    public static void main(String[] args) {
        testClassLoader();
    }

    public static void testClassLoader(){
        try {
            Class.forName("cn.whlit.classloader.DemoClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Class<?> clazz = myClassLoader.loadClass("cn.whlit.classloader.DemoClass");
            Object o = clazz.newInstance();
            Method say = clazz.getMethod("say");
            say.invoke(o);
            Class.forName("cn.whlit.classloader.DemoClass");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}