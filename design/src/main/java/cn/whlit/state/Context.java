package cn.whlit.state;

/**
 * @author WangHaiLong 2023/5/8 21:44
 */
public class Context {
    //定义状态
    public final static State STATE1 = new ConcreteState1();
    public final static State STATE2 = new ConcreteState2();
    //当前的状态
    private State currentState;
    public State getCurrentState() {
        return currentState;
    }
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }
    public void handle1(){
        this.currentState.handle1();
    }
    public void handle2(){
        this.currentState.handle2();
    }
}
