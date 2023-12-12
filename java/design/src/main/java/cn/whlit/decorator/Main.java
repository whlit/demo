package cn.whlit.decorator;

/**
 * @author WangHaiLong 2023/5/1 17:30
 */
public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //第一次装饰
        component = new ConcreteDecorator1(component);
        //第二次装饰
        component = new ConcreteDecorator2(component);
        //装饰后执行
        component.operate();
    }
}
