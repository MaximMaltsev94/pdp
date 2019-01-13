package pdp.enums;

import java.util.*;

public enum DefaultCollectionFactory {
    ArrayList {
        @Override
        protected <T> Collection<T> getCollectionInstance() {
            return new ArrayList<>();
        }
    },
    LinkedList {
        @Override
        protected <T> Collection<T> getCollectionInstance() {
            return new LinkedList<>();
        }
    },
    Queue {
        @Override
        protected <T> Collection<T> getCollectionInstance() {
            return new LinkedList<>();
        }
    },
    HashSet {
        @Override
        protected <T> Collection<T> getCollectionInstance() {
            return new HashSet<>();
        }
    };

    public final <T> Collection<T> of(T... elements) {
        Collection<T> result = getCollectionInstance();
        Collections.addAll(result, elements);
        return result;
    }

    protected abstract <T> Collection<T> getCollectionInstance();
}
