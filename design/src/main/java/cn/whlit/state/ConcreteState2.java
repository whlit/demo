package cn.whlit.state;

/**
 * @author WangHaiLong 2023/5/8 21:45
 */
public class ConcreteState2 extends State{
    @Override
    public void handle1() {
        super.context.setCurrentState(Context.STATE1);
        super.context.handle1();
    }

    @Override
    public void handle2() {
        //本状态下必须处理的逻辑
    }
}
