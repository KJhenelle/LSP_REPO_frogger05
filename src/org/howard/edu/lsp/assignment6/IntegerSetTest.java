package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
    private IntegerSet set;

    @BeforeEach
    void setUp() {
        set = new IntegerSet();
    }

    @Test
    @DisplayName("Test add() - Normal and Duplicate")
    void testAdd() {
        set.add(1);
        assertEquals(1, set.length()); // Normal [cite: 95]
        set.add(1); 
        assertEquals(1, set.length(), "Duplicate should not increase length"); // Edge [cite: 98]
    }

    @Test
    @DisplayName("Test remove() - Normal and Missing")
    void testRemove() {
        set.add(1);
        set.remove(1);
        assertFalse(set.contains(1)); // Normal [cite: 95]
        set.remove(99); // Edge: value not present [cite: 99]
        assertEquals(0, set.length());
    }

    @Test
    @DisplayName("Test equals() - Order and Mismatch")
    void testEquals() {
        IntegerSet set2 = new IntegerSet();
        set.add(1); set.add(2);
        set2.add(2); set2.add(1);
        assertTrue(set.equals(set2), "Same elements in different order should be equal"); // Edge [cite: 100]
        set2.add(3);
        assertFalse(set.equals(set2)); // Normal [cite: 95]
    }

    @Test
    @DisplayName("Test largest() - Normal and Exception")
    void testLargest() {
        set.add(5);
        assertEquals(5, set.largest()); // Edge: single element [cite: 108]
        set.add(10);
        assertEquals(10, set.largest()); // Normal [cite: 95]
        
        IntegerSet emptySet = new IntegerSet();
        assertThrows(RuntimeException.class, () -> emptySet.largest()); // Edge: Exception [cite: 108, 115]
    }

    @Test
    @DisplayName("Test union() - Normal and Empty")
    void testUnion() {
        IntegerSet set2 = new IntegerSet();
        set.add(1);
        IntegerSet result = set.union(set2);
        assertEquals("[1]", result.toString(), "Union with empty set"); // Edge [cite: 101]
    }

    @Test
    @DisplayName("Test intersect() - Normal and No Overlap")
    void testIntersect() {
        IntegerSet set2 = new IntegerSet();
        set.add(1);
        set2.add(2);
        IntegerSet result = set.intersect(set2);
        assertTrue(result.isEmpty(), "Intersection with no common elements should be empty"); // Edge [cite: 102]
    }

    @Test
    @DisplayName("Test diff() - Normal and Identical")
    void testDiff() {
        IntegerSet set2 = new IntegerSet();
        set.add(1); set2.add(1);
        IntegerSet result = set.diff(set2);
        assertTrue(result.isEmpty(), "Difference of identical sets should be empty"); // Edge [cite: 103]
    }

    @Test
    @DisplayName("Test complement() - Normal and Disjoint")
    void testComplement() {
        IntegerSet set2 = new IntegerSet();
        set.add(1);
        set2.add(2);
        IntegerSet result = set.complement(set2);
        assertEquals("[2]", result.toString(), "Complement of disjoint sets"); // Edge [cite: 104]
    }

    @Test
    @DisplayName("Test toString() - Normal and Empty")
    void testToString() {
        set.add(2); set.add(1);
        assertEquals("[1, 2]", set.toString()); // Normal [cite: 118]
        set.clear();
        assertEquals("[]", set.toString()); // Edge [cite: 107]
    }
}