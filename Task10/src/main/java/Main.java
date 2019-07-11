import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(1, "Sergey");
        hash.put(2, "Katya");
        hash.put(3, "Sergey");
        hash.put(4, "Aleksander");
        hash.put(5, "Aleksey");

        System.out.println(hash);
        System.out.println(inverse(hash));

    }

    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map) {
        Map<V, Collection<K>> resultMap = new HashMap<>();

        Set<K> keys = (Set<K>) map.keySet();
        for (K key : keys) {
            V value = map.get(key);
            resultMap.compute(value, (v, ks) -> {
                if (ks == null) {
                    ks = new ArrayList<>();
                }
                ks.add(key);
                return ks;
            });
        }

        return resultMap;
    }
}
