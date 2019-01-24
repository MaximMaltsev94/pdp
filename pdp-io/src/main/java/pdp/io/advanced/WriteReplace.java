package pdp.io.advanced;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class WriteReplace implements Serializable {
    private String name;

    public WriteReplace(String name) {
        this.name = name;
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace()");
        return new WriteReplace("written custom name");
    }

//    private Object readResolve() throws ObjectStreamException {
//        System.out.println("readResolve()");
//        return new WriteReplace("read custom name");
//    }

    @Override
    public String toString() {
        return "WriteReplace{" +
                "name='" + name + '\'' +
                '}';
    }
}
