package pdp.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableImpl implements Externalizable {

    private int i;
    private String str;

    public ExternalizableImpl() {
    }

    public ExternalizableImpl(int i, String str) {
        this.i = i;
        this.str = str;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Externalizable serialization");
        out.writeInt(i);
        out.writeUTF(str);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Externalizable deserialization");
        i = in.readInt();
        str = in.readUTF();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "ExternalizableImpl{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }
}
