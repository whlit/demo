package cn.whlit.demo.inter;

/**
 * @author WangHaiLong 2024/2/18 21:42
 */
public interface DemoInterface {

    // 不可以有私有成员变量
//    private String name;

    // 声明的变量为常量
    String name = "ZhangSan";

    //可以有私有方法
    private void test(){
        System.out.println("接口的私有方法");
    }

    // 接口中的私有方法必须有实现
//    private void test2();

    default void doTest(){
        System.out.println("接口方法的默认实现");
        test();
    }

    // 可以有静态方法
    public static void main(String[] args) {
        System.out.println(name);
        // name 为常量
//        name = "李四";
    }
}
