package cn.whlit.proxy;

/**
 * 人类的代理类，同样实现了人类的方法
 * @author WangHaiLong 2023/4/17 22:04
 */
public class PeopleProxy extends People{

    //内部包含对实际对象的引用
    private People people;

    public PeopleProxy(People people) {
        this.people = people;
    }

    //对实际对象的方法进行加强，或者对实际对象的使用加以约束，例如可以使用代理类来实现权限的控制，实际类只需要实现对应的操作，而无需关心权限问题
    @Override
    public void eat() {
        System.out.println(people.getName() + "开始吃饭");
        people.eat();
        System.out.println(people.getName() + "吃完饭了");
    }

    @Override
    public void say() {
        System.out.println(people.getName() + "开始说话");
        people.say();
        System.out.println(people.getName() + "说完话了");
    }

}
