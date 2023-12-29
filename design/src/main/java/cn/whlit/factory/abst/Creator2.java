package cn.whlit.factory.abst;

/**
 * @author WangHaiLong 2023/4/28 11:44
 */
public class Creator2 extends AbstractCreator{
    @Override
    public AbstractProductA createAbstractProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createAbstractProductB() {
        return new ProductB2();
    }
}
