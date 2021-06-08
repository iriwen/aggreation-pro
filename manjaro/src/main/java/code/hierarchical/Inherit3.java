package code.hierarchical;

/**
 * created by iriwen on 2021/05/26.
 */
public class Inherit3 extends Inherit2 {

    public static void main(String[] args) {
        Inherit3 inherit3 = new Inherit3();
        inherit3.method();
    }

    public void init(){
        System.out.println("init in Inherit3");
    }
}
