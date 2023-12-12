package cn.whlit.singleton;

/**
 * 单例示例(饿汉式)
 * 饿汉式是在类加载的时候就进行了初始化，无论是否使用
 * @author WangHaiLong 2023/4/17 21:34
 */
public class SingleDemo {

    //私有构造方法
    private SingleDemo() {
    }

    private static SingleDemo singleDemo = new SingleDemo();

    //对外提供实例的获取方法
    public static SingleDemo getInstance(){
        return singleDemo;
    }
}
