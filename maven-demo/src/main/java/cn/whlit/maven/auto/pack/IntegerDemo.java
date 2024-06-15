package cn.whlit.maven.auto.pack;

/**
 * @author WangHaiLong 2024/6/11 12:53
 */
public class IntegerDemo {

    public static void main(String[] args) {
        Integer v = null;
        Boolean flag = true;
        // 三元表达式的两个返回值需要是相同类型 由于右侧是int类型，所以v会自动调用 intValue()方法
        System.out.println(flag ? v : 0);
        // 右侧为Integer类型时，左右都是一样的类型，所以v会原样返回
        System.out.println(flag ? v : Integer.valueOf(0));
    }
}
