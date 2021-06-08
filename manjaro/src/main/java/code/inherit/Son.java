package code.inherit;

/**
 * created by iriwen on 2020/06/18.
 */
public class Son extends Parent {

    //public String name ;

    public Son(String name) {
        super(name);
    }

    public static void main(String[] args) {

        Son son = new Son("test01");
        System.out.println(son.getName());
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name;
    }

}
