package cn.whlit.singleton;

/**
 * 单例示例(懒汉式)
 * 懒汉式是在第一次需要调用时才进行初始化
 * 此类列举的方式是最简单的方式，但是存在线程安全问题
 * 解决方式可以参考 {@link SingleDemo3}
 * @author WangHaiLong 2023/4/17 21:34
 */
public class SingleDemo2 {

    //私有构造方法
    private SingleDemo2() {
    }

    private static SingleDemo2 singleDemo;

    //对外提供实例的获取方法，
    public static SingleDemo2 getInstance(){
        if(singleDemo == null){
            singleDemo = new SingleDemo2();
        }
        return singleDemo;
    }
}
