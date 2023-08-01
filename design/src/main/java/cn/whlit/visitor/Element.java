package cn.whlit.visitor;

/**
 * @author WangHaiLong 2023/5/8 16:37
 */
public abstract class Element {
    //定义业务逻辑
    public abstract void doSomething();
    //允许访问的访问者
    public abstract void accept(IVisitor visitor);
}
