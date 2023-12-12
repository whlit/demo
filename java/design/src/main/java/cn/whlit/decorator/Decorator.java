package cn.whlit.decorator;

/**
 * @author WangHaiLong 2023/5/1 17:32
 */
public abstract class Decorator extends Component{
    private Component component;
    //通过构造函数传递被修饰者
    public Decorator(Component component) {
        this.component = component;
    }
    //委托给被修饰者执行
    @Override
    public void operate() {
        this.component.operate();
    }
}
