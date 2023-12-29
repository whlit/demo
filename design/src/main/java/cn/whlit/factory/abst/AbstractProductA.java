package cn.whlit.factory.abst;

/**
 * @author WangHaiLong 2023/4/28 11:37
 */
public abstract class AbstractProductA {
    //共有的方法
    public void method1(){
        //业务逻辑
    }
    //特有的相同方法，不同实现
    public abstract void method2();
}
