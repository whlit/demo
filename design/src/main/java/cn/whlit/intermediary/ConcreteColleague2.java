package cn.whlit.intermediary;

/**
 * @author WangHaiLong 2023/4/28 22:46
 */
public class ConcreteColleague2 extends Colleague{
    //通过构造函数传递中介者
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }
    //自有方法
    public void selfMethod2(){
        //业务逻辑
    }
    //依赖方法
    public void depMethod2(){
        //业务逻辑
        //自己不能处理的业务逻辑，委托给中介者处理
        super.mediator.doSomething2();
    }
}
