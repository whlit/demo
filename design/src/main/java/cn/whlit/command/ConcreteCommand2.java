package cn.whlit.command;

/**
 * @author WangHaiLong 2023/4/30 18:31
 */
public class ConcreteCommand2 extends Command{
    //对哪个接收类进行命令处理
    private Receiver receiver;
    //构造函数传递接收者
    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }
    //必须实现一个命令
    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}
