package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class representing a mathematical set of integers.
 * Elements are stored in an ArrayList and duplicates are not allowed.
 */
public class IntegerSet {
    // Internal storage for set elements 
    private List<Integer> set;

    /**
     * Default constructor that initializes an empty set.
     */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /**
     * Constructor to initialize a set with an existing list of integers.
     * @param set an ArrayList of integers to initialize the set
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set);
    }

    /**
     * Clears the internal representation of the set[cite: 22].
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set[cite: 23].
     * @return the length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if this set and the provided set contain the same elements[cite: 24].
     * Order does not matter[cite: 52].
     * @param b the IntegerSet to compare with
     * @return true if sets are equal, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) {
            return false;
        }
        return set.containsAll(b.set) && b.set.containsAll(set);
    }

    /**
     * Returns true if the set contains the specified value[cite: 25].
     * @param value the integer to check for
     * @return true if the value is in the set
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set[cite: 26].
     * @return the maximum integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set[cite: 27].
     * @return the minimum integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present[cite: 28].
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists[cite: 29].
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set representing the union of this set and another[cite: 30].
     * Does not modify original sets.
     * @param intSetb the set to union with
     * @return a new IntegerSet containing elements from both sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        ArrayList<Integer> unionList = new ArrayList<>(this.set);
        for (Integer item : intSetb.set) {
            if (!unionList.contains(item)) {
                unionList.add(item);
            }
        }
        return new IntegerSet(unionList);
    }

    /**
     * Returns a new set representing the intersection of this set and another[cite: 31].
     * Does not modify original sets.
     * @param intSetb the set to intersect with
     * @return a new IntegerSet containing common elements
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        ArrayList<Integer> intersectList = new ArrayList<>(this.set);
        intersectList.retainAll(intSetb.set);
        return new IntegerSet(intersectList);
    }

    /**
     * Returns a new set containing elements in this set but not in b[cite: 32].
     * (Set Difference: Set1 - Set2) [cite: 45].
     * @param intSetb the set to subtract
     * @return a new IntegerSet containing the difference
     */
    public IntegerSet diff(IntegerSet intSetb) {
        ArrayList<Integer> diffList = new ArrayList<>(this.set);
        diffList.removeAll(intSetb.set);
        return new IntegerSet(diffList);
    }

    /**
     * Returns a new set containing elements in b but not in this set[cite: 33].
     * (Set Complement: Set2 - Set1) [cite: 48].
     * @param intSetb the set to compare against
     * @return a new IntegerSet containing elements only in b
     */
    public IntegerSet complement(IntegerSet intSetb) {
        ArrayList<Integer> complementList = new ArrayList<>(intSetb.set);
        complementList.removeAll(this.set);
        return new IntegerSet(complementList);
    }

    /**
     * Returns true if the set is empty, false otherwise[cite: 34].
     * @return true if the set size is 0
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order[cite: 35].
     * Format: [1, 2, 3][cite: 56, 57, 58].
     * @return the formatted string
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]"; // [cite: 60]
        }
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // [cite: 61]
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < sortedList.size(); i++) {
            sb.append(sortedList.get(i));
            if (i < sortedList.size() - 1) {
                sb.append(", "); // [cite: 58]
            }
        }
        sb.append("]");
        return sb.toString();
    }
}