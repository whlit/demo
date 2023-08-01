package cn.whlit.state;

/**
 * @author WangHaiLong 2023/5/8 21:42
 */
public abstract class State {
    //定义一个环境对象，提供子类访问
    protected Context context;
    //设置环境对象
    public void setContext(Context context) {
        this.context = context;
    }
    //行为1
    public abstract void handle1();
    //行为2
    public abstract void handle2();
}
