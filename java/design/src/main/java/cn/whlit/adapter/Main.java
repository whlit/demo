package cn.whlit.adapter;

/**
 * @author WangHaiLong 2023/5/3 13:29
 */
public class Main {
    public static void main(String[] args) {
        //原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();

        //增加的适配器角色的业务逻辑
        Target adapter = new Adapter();
        adapter.request();
    }
}
