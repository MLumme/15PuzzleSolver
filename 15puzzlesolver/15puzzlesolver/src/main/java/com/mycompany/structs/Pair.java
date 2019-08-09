
package com.mycompany.structs;

/**
 * Simple generic Pair class to replace javas own
 * @param <K> key parameter
 * @param <V> value parameter
 */
public class Pair<K, V> {
    private K key;
    private V value;

    /**
     * Constructor to initialize pair
     * @param key key object
     * @param value value object
     */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Getter for pairs key
     * @return key object
     */
    public K getKey() {
        return key;
    }

    /**
     * Getter for pairs value
     * @return value object
     */
    public V getValue() {
        return value;
    }
}
