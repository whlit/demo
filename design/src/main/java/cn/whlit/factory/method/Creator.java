package cn.whlit.factory.method;

/**
 * @author WangHaiLong 2023/4/28 10:22
 */
public abstract class Creator {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
