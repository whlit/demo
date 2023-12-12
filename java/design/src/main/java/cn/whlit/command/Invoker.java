package cn.whlit.command;

/**
 * @author WangHaiLong 2023/4/30 18:32
 */
public class Invoker {
    private Command command;
    //接收命令
    public void setCommand(Command command) {
        this.command = command;
    }
    //执行命令
    public void action(){
        this.command.execute();
    }
}
