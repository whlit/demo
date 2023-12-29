package cn.whlit.backup;

/**
 * @author WangHaiLong 2023/5/7 16:46
 */
public class Main {
    public static void main(String[] args) {
        //定义发起人
        Originator originator = new Originator();
        //定义备忘录管理员
        Caretaker caretaker = new Caretaker();
        //创建一个备忘录
        caretaker.setMemento(originator.createMemento());
        //恢复一个备忘录
        originator.restoreMemento(caretaker.getMemento());
    }
}
