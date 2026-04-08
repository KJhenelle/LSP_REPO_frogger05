package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 Test Suite for IntegerSet implementation.
 */
public class IntegerSetTest {
    private IntegerSet set;

    @BeforeEach
    void setUp() {
        set = new IntegerSet();
    }

    @Test
    @DisplayName("Test clear() method")
    void testClear() {
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty(), "Set should be empty after clear [cite: 22, 34]");
        assertEquals(0, set.length(), "Length should be 0 after clear [cite: 23]");
    }

    @Test
    @DisplayName("Test length() method")
    void testLength() {
        assertEquals(0, set.length());
        set.add(1);
        set.add(2);
        assertEquals(2, set.length(), "Length should reflect number of unique elements [cite: 23]");
    }

    @Test
    @DisplayName("Test equals() method")
    void testEquals() {
        IntegerSet set2 = new IntegerSet();
        set.add(1); set.add(2);
        set2.add(2); set2.add(1);
        assertTrue(set.equals(set2), "Sets with same elements in different order should be equal [cite: 52]");
        
        set2.add(3);
        assertFalse(set.equals(set2), "Sets with different elements should not be equal [cite: 52]");
    }

    @Test
    @DisplayName("Test largest() and smallest() with exceptions")
    void testMinMax() {
        set.add(10);
        set.add(5);
        set.add(20);
        assertEquals(20, set.largest(), "Should return the maximum value [cite: 26]");
        assertEquals(5, set.smallest(), "Should return the minimum value [cite: 27]");
        
        set.clear();
        assertThrows(RuntimeException.class, () -> set.largest(), "Should throw exception if empty ");
    }

    @Test
    @DisplayName("Test add() and remove()")
    void testAddRemove() {
        set.add(1);
        set.add(1); // Duplicate [cite: 5]
        assertEquals(1, set.length(), "Duplicates should not be added [cite: 5]");
        
        set.remove(1);
        assertFalse(set.contains(1), "Element should be removed [cite: 29]");
    }

    @Test
    @DisplayName("Test union() operation")
    void testUnion() {
        IntegerSet set2 = new IntegerSet();
        set.add(1); set.add(2);
        set2.add(2); set2.add(3);
        
        IntegerSet result = set.union(set2);
        assertEquals("[1, 2, 3]", result.toString(), "Union should contain all unique elements [cite: 40]");
        assertEquals(2, set.length(), "Original set should not be modified [cite: 37]");
    }

    @Test
    @DisplayName("Test intersect() operation")
    void testIntersect() {
        IntegerSet set2 = new IntegerSet();
        set.add(1); set.add(2);
        set2.add(2); set2.add(3);
        
        IntegerSet result = set.intersect(set2);
        assertEquals("[2]", result.toString(), "Intersection should only contain common elements [cite: 43]");
    }

    @Test
    @DisplayName("Test difference() and complement()")
    void testDiffAndComplement() {
        IntegerSet set2 = new IntegerSet();
        set.add(1); set.add(2);
        set2.add(2); set2.add(3);
        
        assertEquals("[1]", set.diff(set2).toString(), "Difference should be elements in set1 but not set2 [cite: 46]");
        assertEquals("[3]", set.complement(set2).toString(), "Complement should be elements in set2 but not set1 [cite: 49]");
    }

    @Test
    @DisplayName("Test toString() requirements")
    void testToString() {
        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals("[1, 2, 3]", set.toString(), "Output must be ascending and formatted correctly [cite: 57, 58]");
        
        set.clear();
        assertEquals("[]", set.toString(), "Empty set should return [] [cite: 60]");
    }
}