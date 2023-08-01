package cn.whlit.backup;

/**
 * @author WangHaiLong 2023/5/7 16:49
 */
public class Memento {
    //发起人的内部状态
    private String state = "";
    //构造函数传递状态

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
