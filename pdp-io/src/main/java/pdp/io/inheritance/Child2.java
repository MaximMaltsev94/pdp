package pdp.io.inheritance;

import java.io.Serializable;

public class Child2 extends Parent2 implements Serializable {
    public Child2() {
        System.out.println("Constructor child 2");
    }
}
