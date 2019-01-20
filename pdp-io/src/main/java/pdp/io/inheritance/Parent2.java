package pdp.io.inheritance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Parent2 implements Externalizable {
    public Parent2() {
        System.out.println("Constructor parent 2");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Parent 2 write external");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Parent 2 read external");
    }
}
