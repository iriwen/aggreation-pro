package code.designPattern.strategy;

/**
 * created by iriwen on 2020/05/08.
 */
public class StrategyContext {

    private final Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double num) {
        return this.strategy.getResult(num);
    }
}
