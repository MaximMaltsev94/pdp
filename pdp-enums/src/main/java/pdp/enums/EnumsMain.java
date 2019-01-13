package pdp.enums;

import java.util.Collection;

public class EnumsMain {

    public static void test(DefaultCollectionFactory factory) {
        Collection<String> collection = factory.of("1", "2", "3");
        System.out.println(String.format("Enum: %s generated collection of type %s", factory.name(), collection.getClass()));
    }

    public static void main(String[] args) {
        test(DefaultCollectionFactory.ArrayList);
        test(DefaultCollectionFactory.LinkedList);
        test(DefaultCollectionFactory.Queue);
        test(DefaultCollectionFactory.HashSet);
    }
}
