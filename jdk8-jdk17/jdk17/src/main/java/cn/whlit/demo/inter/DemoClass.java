package cn.whlit.demo.inter;

/**
 * @author WangHaiLong 2024/2/18 21:47
 */
public class DemoClass {

    private String name;

    private static String sName;

    public static String cName = "ZhangSan";

    public static void main(String[] args) {
        System.out.println(cName);
        cName = "LiSi";
        System.out.println(DemoClass.cName);
        DemoClass demoClass = new DemoClass();
        System.out.println(demoClass.cName);
    }
}
