package cn.whlit.visitor;

/**
 * @author WangHaiLong 2023/5/8 16:38
 */
public interface IVisitor {
    //可以访问那些对象
    public void visit(ConcreteElement1 element);
    public void visit(ConcreteElement2 element);
}
