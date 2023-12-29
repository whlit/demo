package cn.whlit.proxy;

public class Main {
    public static void main(String[] args) {
        Man man = new Man();
        man.setName("张三");
        PeopleProxy proxy = new PeopleProxy(man);
        proxy.eat();
        proxy.say();

    }
}