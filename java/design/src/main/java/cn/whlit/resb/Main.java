package cn.whlit.resb;

/**
 * @author WangHaiLong 2023/5/1 16:53
 */
public class Main {
    public static void main(String[] args) {
        //声明所有的处理者
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        //设置链中的处理顺序
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        //提交请求，返回处理结果
        Response response = handler1.handleMessage(new Request());
    }
}
