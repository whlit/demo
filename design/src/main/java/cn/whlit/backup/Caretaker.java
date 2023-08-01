package cn.whlit.backup;

/**
 * @author WangHaiLong 2023/5/7 16:51
 */
public class Caretaker {
    //备忘录对象
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
