package cn.whlit.composite;

/**
 * @author WangHaiLong 2023/5/6 21:27
 */
public class Main {
    public static void main(String[] args) {
        //创建一个根节点
        Composite root = new Composite();
        root.doSomething();
        //创建一个树枝构件
        Composite branch = new Composite();
        root.add(branch);
        //创建一个叶子节点
        Leaf leaf = new Leaf();
        root.add(leaf);
    }
}
