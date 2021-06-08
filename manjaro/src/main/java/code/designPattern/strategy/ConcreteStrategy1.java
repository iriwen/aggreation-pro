package code.designPattern.strategy;

/**
 * created by iriwen on 2020/05/08.
 */
public class ConcreteStrategy1 implements  Strategy {

    @Override
    public double getResult(double num) {

        return num * 0.8;
    }
}
