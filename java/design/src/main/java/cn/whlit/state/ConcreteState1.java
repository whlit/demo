package cn.whlit.state;

/**
 * @author WangHaiLong 2023/5/8 21:45
 */
public class ConcreteState1 extends State{
    @Override
    public void handle1() {
        //本状态下必须处理的逻辑
    }

    @Override
    public void handle2() {
        super.context.setCurrentState(Context.STATE2);
        super.context.handle2();
    }
}
