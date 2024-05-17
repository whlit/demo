package cn.whlit.demo.inter;

/**
 * @author WangHaiLong 2024/2/18 21:51
 */
public class DemoImpl implements DemoInterface{

    String name = "LiSi";

    public static void main(String[] args) {
        DemoImpl demo = new DemoImpl();
        demo.doTest();
        // 在接口上的name为常量
        System.out.println(DemoInterface.name);
        // 在实现类上重新声明的name变量为成员变量
        System.out.println(demo.name);
        demo.name = "王五";
        System.out.println(demo.name);
    }
}
