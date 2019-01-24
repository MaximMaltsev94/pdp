package pdp.io;

import pdp.io.advanced.ReadObjectNoData;
import pdp.io.advanced.ReadObjectNoDataChild;
import pdp.io.advanced.ReadResolve;
import pdp.io.advanced.WriteReplace;
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

        test(new ReadObjectNoData("Maxim"));

        test(new WriteReplace("111"));
        test(new ReadResolve("222"));

        /*
            How to test ReadObjectNoData.readObjectNoData() method:
                step 1. execute program as is now
                step 2. comment line 1 and uncomment lines 2, 3
                step 3. make ReadObjectNoDataChild extends ReadObjectNoData
                step 4. execute program and observe the magic in console window
         */
        writeToFile(new ReadObjectNoDataChild());                               // line 1
//        ReadObjectNoDataChild o = (ReadObjectNoDataChild) readFromFile();     // line 2
//        System.out.println(o);                                                // line 3
    }

    private static final String TEST_FILE_NAME = "1.txt";

    private static void writeToFile(Object object) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(TEST_FILE_NAME))) {
            objectOutputStream.writeObject(object);
        }
    }

    private static Object readFromFile() throws IOException, ClassNotFoundException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(TEST_FILE_NAME))) {
            return objectInputStream.readObject();
        }
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

        System.out.println("-----------------------------------------------\\");
        byte[] bytes = writeToArray(testedObject);
        System.out.println(testedObject.toString());
        Object deserializedTestedObject = readObjectFromArray(bytes);
        System.out.println(deserializedTestedObject.toString());
        System.out.println("-----------------------------------------------/");
        System.out.println();
        System.out.println();
    }
}
