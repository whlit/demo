package cn.whlit.command;

/**
 * @author WangHaiLong 2023/4/30 18:16
 */
public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new ConcreteReceiver1();
        Command command = new ConcreteCommand1(receiver);
        invoker.setCommand(command);
        invoker.action();
    }
}
