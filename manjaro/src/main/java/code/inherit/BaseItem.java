package code.inherit;

/**
 * created by iriwen on 2020/06/19.
 */

public class BaseItem implements CustomButton.AbstractDelegate {

    @Override
    public void doSomething(String v) {
        System.out.println("I do this thing : " + v);
    }
}

