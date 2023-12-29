package cn.whlit.factory.abst;

/**
 * @author WangHaiLong 2023/4/28 13:12
 */
public class Main {

    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();
        AbstractProductB b1 = creator1.createAbstractProductB();
        AbstractProductA a1 = creator1.createAbstractProductA();
        AbstractProductA a2 = creator2.createAbstractProductA();
        AbstractProductB b2 = creator2.createAbstractProductB();
    }
}
