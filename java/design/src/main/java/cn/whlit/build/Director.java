package cn.whlit.build;

/**
 * @author WangHaiLong 2023/4/28 14:19
 */
public class Director {
    private Builder builder = new ConcreteBuilder();
    public Product getAProduct(){
        builder.setPart();
        return builder.buildProduct();
    }
}
