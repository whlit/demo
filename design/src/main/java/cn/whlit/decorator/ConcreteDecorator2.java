package cn.whlit.decorator;

/**
 * @author WangHaiLong 2023/5/1 17:34
 */
public class ConcreteDecorator2 extends Decorator{
    private void method(){
        //自己的修饰方法
    }
    @Override
    public void operate() {
        this.method();
        super.operate();
    }
    public ConcreteDecorator2(Component component) {
        super(component);
    }
}
