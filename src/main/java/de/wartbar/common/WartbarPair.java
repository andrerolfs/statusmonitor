package de.wartbar.common;

public class WartbarPair<T> {
    private T key;
    private T value;

    public WartbarPair(T key, T value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() { return this.key; }
    public T getValue() { return this.value; }
}
