import java.util.*;

class MyHashMap {

    private final int SIZE = 1000; // total number of buckets
    private List<int[]>[] buckets;

    public MyHashMap() {
        buckets = new ArrayList[SIZE]; // initialize bucket array
    }

    private int hash(int key) {
        return key % SIZE; // simple hash function
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }

        // Check if key already exists → update it
        for (int[] pair : buckets[index]) {
            if (pair[0] == key) {
                pair[1] = value; // update existing key
                return;
            }
        }

        // Key doesn't exist → insert new pair
        buckets[index].add(new int[]{key, value});
    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) return -1;

        for (int[] pair : buckets[index]) {
            if (pair[0] == key) {
                return pair[1];
            }
        }

        return -1; // key not found
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) return;

        Iterator<int[]> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            int[] pair = iterator.next();
            if (pair[0] == key) {
                iterator.remove(); // remove the pair safely
                return;
            }
        }
    }
}
