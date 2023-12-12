package cn.whlit.observer;

import java.util.Vector;

/**
 * @author WangHaiLong 2023/5/6 22:58
 */
public abstract class Subject {
    private Vector<Observer> vector = new Vector<>();
    //增加一个观察者
    public void addObserver(Observer observer){
        this.vector.add(observer);
    }
    //删除一个观察者
    public void delObserver(Observer observer){
        this.vector.remove(observer);
    }
    //通知所有观察者
    public void notifyObservers(){
        for (Observer observer : this.vector) {
            observer.update();
        }
    }
}
