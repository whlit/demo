package cn.whlit.proxy;

/**
 * 用户类,抽象用户的行为
 * @author WangHaiLong 2023/4/17 21:58
 */
public abstract class People {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void say();

}
