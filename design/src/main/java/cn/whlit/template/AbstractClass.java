package cn.whlit.template;

/**
 * @author WangHaiLong 2023/4/28 13:29
 */
public abstract class AbstractClass {

    protected abstract void doSomething();

    protected abstract void doAnything();

    public void templateMethod(){
        this.doAnything();
        this.doSomething();
    }

}
