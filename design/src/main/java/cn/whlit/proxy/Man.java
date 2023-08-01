package cn.whlit.proxy;

/**
 * 男人类，实现人类的方法
 * @author WangHaiLong 2023/4/17 22:01
 */
public class Man extends People{
    @Override
    public void eat() {
        System.out.println("吃一碗面条");
    }

    @Override
    public void say() {
        System.out.println("我是男人");
    }

}
