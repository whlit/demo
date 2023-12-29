package cn.whlit.factory.method;

public class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        ConcreteProduct1 product = creator.createProduct(ConcreteProduct1.class);
    }
}