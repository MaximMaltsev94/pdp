package pdp.io;

import java.io.*;

public class TwoInterfaces implements Serializable, Externalizable {
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("invoked externalazible instead of serializable");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("invoked externalazible instead of serializable");
    }
}
