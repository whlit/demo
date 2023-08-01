package cn.whlit.visitor;

/**
 * @author WangHaiLong 2023/5/8 16:45
 */
public class Visitor implements IVisitor{
    @Override
    public void visit(ConcreteElement1 element) {
        element.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 element) {
        element.doSomething();
    }
}
