package pdp.io.advanced;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class ReadResolve implements Serializable {

    private String name;

    public ReadResolve(String name) {
        this.name = name;
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("readResolve()");
        return new WriteReplace("read custom name");
    }

    @Override
    public String toString() {
        return "ReadResolve{" +
                "name='" + name + '\'' +
                '}';
    }
}
