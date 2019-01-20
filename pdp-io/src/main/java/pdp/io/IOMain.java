package pdp.io;

import pdp.io.inheritance.Child1;
import pdp.io.inheritance.Child2;
import pdp.io.inheritance.Parent1;
import pdp.io.inheritance.Parent2;

import java.io.*;
import java.util.Arrays;

public class IOMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        test(new SerializableImpl(10, "hello", 115));
        test(new ExternalizableImpl(54, "good buy"));
        test(new CustomSerialization(1994, "good year"));

        test(new TwoInterfaces());

        test(new Parent1());
        test(new Parent2());
        test(new Child1());
        test(new Child2());
    }

    private static <T> byte[] writeToArray(T object) throws IOException {
        try(ByteArrayOutputStream bytes = new ByteArrayOutputStream(1024);
            ObjectOutputStream objectOut = new ObjectOutputStream(bytes)) {
            objectOut.writeObject(object);
            return bytes.toByteArray();
        }
    }

    private static Object readObjectFromArray(byte[] array) throws IOException, ClassNotFoundException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(array))) {
            return objectInputStream.readObject();
        }
    }

    private static <T> void test(T testedObject) throws IOException, ClassNotFoundException {
        byte[] bytes = writeToArray(testedObject);
        Object deserializedTestedObject = readObjectFromArray(bytes);

        System.out.println("-----------------------------------------------\\");
        System.out.println(testedObject.toString());
        System.out.println(deserializedTestedObject.toString());
        System.out.println("-----------------------------------------------/");
        System.out.println();
        System.out.println();
    }
}
