package cn.whlit.command;

/**
 * @author WangHaiLong 2023/4/30 18:29
 */
public abstract class Command {
    //每个命令类都必须有一个执行命令的方法
    public abstract void execute();
}
