package cn.whlit.intermediary;

/**
 * @author WangHaiLong 2023/4/28 22:46
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
