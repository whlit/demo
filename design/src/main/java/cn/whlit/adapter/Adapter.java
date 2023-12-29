package cn.whlit.adapter;

/**
 * @author WangHaiLong 2023/5/3 13:32
 */
public class Adapter extends Source implements Target{
    @Override
    public void request() {
        super.doSomething();
    }
}
