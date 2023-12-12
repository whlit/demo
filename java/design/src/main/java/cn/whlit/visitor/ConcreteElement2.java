package cn.whlit.visitor;

/**
 * @author WangHaiLong 2023/5/8 16:41
 */
public class ConcreteElement2 extends Element{
    @Override
    public void doSomething() {
        //业务逻辑
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
