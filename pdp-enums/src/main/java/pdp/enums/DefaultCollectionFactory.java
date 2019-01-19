package pdp.enums;

import java.util.*;

public enum DefaultCollectionFactory {
    ArrayList(50) {
        @Override
        protected <T> Collection<T> getCollectionInstance() {
            return new ArrayList<>(defaultSize);
        }
    },
    LinkedList(10) {
        @Override
        protected <T> Collection<T> getCollectionInstance() {
            return new LinkedList<>();
        }
    },
    Queue(10) {
        @Override
        protected <T> Collection<T> getCollectionInstance() {
            return new LinkedList<>();
        }
    },
    HashSet(100) {
        @Override
        protected <T> Collection<T> getCollectionInstance() {
            return new HashSet<>(defaultSize);
        }
    };

    public final <T> Collection<T> of(T... elements) {
        Collection<T> result = getCollectionInstance();
        Collections.addAll(result, elements);
        return result;
    }

    protected int defaultSize;

    protected abstract <T> Collection<T> getCollectionInstance();

    DefaultCollectionFactory(int defaultSize) {
        this.defaultSize = defaultSize;
    }

    public void actWithInnerField() {
        System.out.println("My initialCapacity is: " + defaultSize);
    }
}
