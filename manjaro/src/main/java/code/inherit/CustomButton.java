package code.inherit;

/**
 * created by iriwen on 2020/06/19.
 */
public class CustomButton {

    private final AbstractDelegate abstractDelegate = new BaseItem();

    public static void main(String[] args) {
        CustomButton customButton = new CustomButton();
        customButton.click();
    }

    public void click(){
        abstractDelegate.doSomething("finished  clicked !");
    }

    interface AbstractDelegate {
        void doSomething(String v);
    }
}
