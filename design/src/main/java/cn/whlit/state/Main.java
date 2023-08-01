package cn.whlit.state;

/**
 * @author WangHaiLong 2023/5/8 21:42
 */
public class Main {
    public static void main(String[] args) {
        //定义环境对象
        Context context = new Context();
        //初始化状态
        context.setCurrentState(new ConcreteState1());
        //行为执行
        context.handle1();
        context.handle2();
    }
}
