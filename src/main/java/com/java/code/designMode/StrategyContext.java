package com.java.code.designMode;

/**
 * created by yuxiaodong01 on 2020/05/08.
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
