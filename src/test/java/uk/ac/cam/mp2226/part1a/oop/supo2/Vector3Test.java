package uk.ac.cam.mp2226.part1a.oop.supo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector3Test {
    @Test
    void compareTo() {
        assertLess(new Vector3(1.0, 2.0, 3.0),
                new Vector3(0.0, 0.2, 4.0));
        assertLess(new Vector3(1.0, 2.0, 3.0),
                new Vector3(0.0, 2.2, 3.0));
        assertLess(new Vector3(1.0, 2.2, 3.0),
                new Vector3(1.1, 2.2, 3.0));
        assertGreater(new Vector3(0.0, 0.2, 4.0),
                new Vector3(1.0, 2.0, 3.0));
        assertGreater(new Vector3(0.0, 2.2, 3.0),
                new Vector3(1.0, 2.0, 3.0));
        assertGreater(new Vector3(1.1, 2.2, 3.0),
                new Vector3(1.0, 2.2, 3.0));
        assertCmpEqual(new Vector3(1.0, 2.2, 3.0),
                new Vector3(1.0, 2.2, 3.0));
    }

    <T extends Comparable<U>, U> void assertLess(T t, U u) {
        assertTrue(t.compareTo(u) < 0);
    }
    <T extends Comparable<U>, U> void assertGreater(T t, U u) {
        assertTrue(t.compareTo(u) > 0);
    }
    <T extends Comparable<U>, U> void assertCmpEqual(T t, U u) {
        assertEquals(0, t.compareTo(u));
    }
}
