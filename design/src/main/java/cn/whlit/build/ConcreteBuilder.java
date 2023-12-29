package cn.whlit.build;

/**
 * @author WangHaiLong 2023/4/28 14:18
 */
public class ConcreteBuilder extends Builder{
    private Product product = new Product();
    @Override
    public void setPart() {

    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
