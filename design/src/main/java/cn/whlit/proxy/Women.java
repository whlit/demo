package cn.whlit.proxy;

/**
 * 女人类，实现人类的方法
 * @author WangHaiLong 2023/4/17 22:02
 */
public class Women extends People{
    @Override
    public void eat() {
        System.out.println("吃一碗大米饭");
    }

    @Override
    public void say() {
        System.out.println("我是女人");
    }

}
