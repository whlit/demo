package cn.whlit.visitor;

/**
 * @author WangHaiLong 2023/5/8 16:36
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Element element = ObjectStructure.createElement();
            element.accept(new Visitor());
        }
    }
}
