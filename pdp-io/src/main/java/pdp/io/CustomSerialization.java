package pdp.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomSerialization implements Serializable {
    private int i;
    private String str;

    public CustomSerialization() {
    }

    public CustomSerialization(int i, String str) {
        this.i = i;
        this.str = str;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Custom serialization");
        out.writeInt(i);
        out.writeUTF(str);
    }

    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        System.out.println("Custom deserialization");
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
        return "CustomSerialization{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }
}
