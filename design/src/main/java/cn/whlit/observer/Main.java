package cn.whlit.observer;

/**
 * @author WangHaiLong 2023/5/6 22:57
 */
public class Main {
    public static void main(String[] args) {
        //创建一个被观察者
        ConcreteSubject subject = new ConcreteSubject();
        //定义一个观察者
        Observer observer = new ConcreteObserver();
        //观察者观察被观察者
        subject.addObserver(observer);
        //观察者活动
        subject.doSomething();
    }

}
