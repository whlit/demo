package cn.whlit.factory.abst;

/**
 * @author WangHaiLong 2023/4/28 11:44
 */
public class Creator1 extends AbstractCreator{
    @Override
    public AbstractProductA createAbstractProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createAbstractProductB() {
        return new ProductB1();
    }
}
