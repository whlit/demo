package cn.whlit.classloader;

/**
 * @author WangHaiLong 2023/8/5 19:01
 */
public class DemoClass {

    private String name;

    public void say(){
        System.out.println("This is a Demo");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
