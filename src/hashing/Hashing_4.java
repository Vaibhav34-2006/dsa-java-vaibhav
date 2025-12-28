package hashing;

import java.util.*;

public class Hashing_4 {

    // ================= CUSTOM HASHMAP IMPLEMENTATION =================
    // This is our own HashMap (NOT java.util.HashMap)
    // It works using:
    // 1. Hashing
    // 2. Buckets (array)
    // 3. LinkedList (chaining)
    // 4. Rehashing

    static class HashMap<K, V> {

        // -------- Node class --------
        // Each Node stores ONE key-value pair
        // Multiple nodes are stored in a LinkedList (bucket)
        private class Node {
            K key;     // key of the map
            V value;   // value associated with key

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;                     
        // size = number of key-value pairs (n)

        private LinkedList<Node>[] buckets;   
        // buckets = array of LinkedLists (N)
        // each index is a bucket

        private static final int DEFAULT_CAPACITY = 4;
        // initial number of buckets

        private static final double LOAD_FACTOR = 0.75;
        // load factor = n / N
        // if exceeded → rehashing happens

        // -------- Constructor --------
        // Initializes bucket array and each LinkedList
        @SuppressWarnings("unchecked")
        public HashMap() {
            buckets = new LinkedList[DEFAULT_CAPACITY];

            // create empty LinkedList for each bucket
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            size = 0; // initially map is empty
        }

        // -------- Hash Function --------
        // Converts key into a valid bucket index
        private int hashFunction(K key) {
            int hashCode = key.hashCode();   // get hash code of key
            return Math.abs(hashCode) % buckets.length;
        }

        // -------- Search in Bucket --------
        // Searches key inside a bucket (LinkedList)
        // Returns index if found, else -1
        private int searchInBucket(K key, int bucketIdx) {
            LinkedList<Node> ll = buckets[bucketIdx];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;   // key found
                }
            }
            return -1; // key not found
        }

        // -------- Rehashing --------
        // When load factor exceeds 0.75
        // Bucket size is doubled
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;

            // double the bucket size
            buckets = new LinkedList[oldBuckets.length * 2];

            // initialize new buckets
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            size = 0; // reset size

            // reinsert all old elements
            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        // -------- Put --------
        // Inserts a new key-value pair
        // If key exists → update value
        public void put(K key, V value) {
            int bucketIdx = hashFunction(key);
            int dataIdx = searchInBucket(key, bucketIdx);

            if (dataIdx != -1) {
                // key already exists → update value
                buckets[bucketIdx].get(dataIdx).value = value;
            } else {
                // new key → add node
                buckets[bucketIdx].add(new Node(key, value));
                size++;
            }

            // check load factor
            double lambda = (double) size / buckets.length;
            if (lambda > LOAD_FACTOR) {
                rehash();
            }
        }

        // -------- containsKey --------
        // Returns true if key exists
        public boolean containsKey(K key) {
            int bucketIdx = hashFunction(key);
            return searchInBucket(key, bucketIdx) != -1;
        }

        // -------- Get --------
        // Returns value for given key
        // Returns null if key not found
        public V get(K key) {
            int bucketIdx = hashFunction(key);
            int dataIdx = searchInBucket(key, bucketIdx);

            if (dataIdx != -1) {
                return buckets[bucketIdx].get(dataIdx).value;
            }
            return null;
        }

        // -------- Remove --------
        // Removes key-value pair and returns value
        public V remove(K key) {
            int bucketIdx = hashFunction(key);
            int dataIdx = searchInBucket(key, bucketIdx);

            if (dataIdx != -1) {
                Node removedNode = buckets[bucketIdx].remove(dataIdx);
                size--;
                return removedNode.value;
            }
            return null;
        }

        // -------- Size --------
        // Returns number of key-value pairs
        public int size() {
            return size;
        }

        // -------- Is Empty --------
        // Returns true if map is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // -------- KeySet --------
        // Returns all keys in an ArrayList
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        // Create custom HashMap object
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert values
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // Access operations
        System.out.println(hm.get("India"));      // 100
        System.out.println(hm.containsKey("US")); // true
        System.out.println(hm.remove("China"));   // 150
        System.out.println(hm.size());            // 4

        // Iterate over keys
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key + " -> " + hm.get(key));
        }
    }
}
