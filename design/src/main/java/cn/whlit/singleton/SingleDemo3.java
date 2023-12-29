package cn.whlit.singleton;

/**
 * 单例示例(懒汉式)
 * 懒汉式是在第一次需要调用时才进行初始化
 * 双重加锁的方式解决线程安全的问题
 * @author WangHaiLong 2023/4/17 21:34
 */
public class SingleDemo3 {

    //私有构造方法
    private SingleDemo3() {
    }

    //利用volatile关键字保证多线程情况下对象的线程间可见性
    private volatile static SingleDemo3 singleDemo;

    //对外提供实例的获取方法，利用双重加锁解决线程安全问题
    public static SingleDemo3 getInstance(){
        if(singleDemo == null){
            synchronized(SingleDemo.class){
                if(singleDemo == null){
                    singleDemo = new SingleDemo3();
                }
            }
        }
        return singleDemo;
    }
}
