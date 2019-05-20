package pdp.rest.jersey.resources;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Maps {
    @SafeVarargs
    public static <K, V> Map<K, V> newHashMap( Map.Entry<K, V> ...entries) {
        Map<K, V> result = new HashMap<>();
        for (Map.Entry<K, V> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return new AbstractMap.SimpleImmutableEntry<>(key, value);
    }
}
