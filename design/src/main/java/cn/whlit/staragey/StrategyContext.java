package cn.whlit.staragey;

public class StrategyContext {
    private Strategy strategy;
    public StrategyContext(Strategy strategy){
        super();
        this.strategy = strategy;
    }

    public void print() {
        strategy.method();
    }
}
