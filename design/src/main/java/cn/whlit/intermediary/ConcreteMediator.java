package cn.whlit.intermediary;

/**
 * @author WangHaiLong 2023/4/28 22:58
 */
public class ConcreteMediator extends Mediator{
    @Override
    public void doSomething1() {
        //调用同事类的方法
        super.c1.selfMethod1();
        super.c1.depMethod1();
    }

    @Override
    public void doSomething2() {
        super.c2.selfMethod2();
        super.c2.depMethod2();
    }
}
