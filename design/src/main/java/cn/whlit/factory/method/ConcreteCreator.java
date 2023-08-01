package cn.whlit.factory.method;

/**
 * @author WangHaiLong 2023/4/28 10:23
 */
public class ConcreteCreator extends Creator{
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        T pruduct = null;
        try {
            pruduct = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            //异常处理
        }
        return pruduct;
    }
}
