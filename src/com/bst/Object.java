package com.bst;

/**
 * Class that wraps a primitive integer. Implements the Comparable interface.
 * @author Patricio Córdova
 */
public class Object implements Comparable<Object> {

    private int value;

    public Object(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(com.bst.Object anotherObject) {
        if (!(anotherObject instanceof Object)) {
            throw new ClassCastException("An instance of Object is expected.");
        }
        if (this.value > anotherObject.value) {
            return 1;
        } else if (this.value < anotherObject.value) {
            return -1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return value+"";
    }
}