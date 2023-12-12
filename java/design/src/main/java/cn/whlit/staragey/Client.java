package cn.whlit.staragey;

public class Client {
    public static void main(String[] args) {
        DXStrategy dxStrategy = new DXStrategy();
        StrategyContext strategyContext = new StrategyContext(dxStrategy);
        strategyContext.print();
    }
}
