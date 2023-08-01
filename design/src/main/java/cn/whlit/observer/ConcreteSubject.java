package cn.whlit.observer;

/**
 * @author WangHaiLong 2023/5/6 23:19
 */
public class ConcreteSubject extends Subject{
    //具体业务
    public void doSomething(){
        super.notifyObservers();
    }
}
