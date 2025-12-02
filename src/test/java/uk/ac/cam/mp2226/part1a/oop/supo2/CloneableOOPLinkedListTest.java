package uk.ac.cam.mp2226.part1a.oop.supo2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import static org.junit.jupiter.api.Assertions.*;

class CloneableOOPLinkedListTest {
    @Test
    void test() {
        CloneableOOPLinkedList ll = new CloneableOOPLinkedList();
        // []
        assertThrows(IllegalStateException.class, ll::getHd);
        assertThrows(IllegalStateException.class, ll::popHd);
        assertThrows(IndexOutOfBoundsException.class, () -> ll.nth(0));
        assertThrows(IndexOutOfBoundsException.class, () -> ll.nth(9));
        assertEquals(0, ll.length());
        ll.pushHd(7);
        // 7 :: []
        assertEquals(7, ll.getHd());
        assertEquals(1, ll.length());
        ll.pushHd(9);
        ll.pushHd(2);
        // 2 :: 9 :: 7 :: []
        assertEquals(7, ll.nth(2));
        assertEquals(2, ll.nth(0));
        assertEquals(3, ll.length());
        assertEquals(2, ll.popHd());
        // 9 :: 7 :: []
        assertEquals(9, ll.getHd());
        ll.pushHd(3);
        // 3 :: 9 :: 7 :: []
        assertEquals(3, ll.popHd());
        assertEquals(9, ll.popHd());
        // 7 :: []
        assertEquals(7, ll.nth(0));
        assertThrows(IndexOutOfBoundsException.class, () -> ll.nth(1));
        assertEquals(7, ll.popHd());
        // []
        assertEquals(0, ll.length());
        assertThrows(IllegalStateException.class, ll::popHd);
        assertThrows(IllegalStateException.class, ll::getHd);
    }

    @Test
    void testClone() {
        CloneableOOPLinkedList ll = new CloneableOOPLinkedList();
        ll.pushHd(9);
        ll.pushHd(2);
        ll.pushHd(5);
        CloneableOOPLinkedList ll2 = wrapAsUnchecked(ll::clone);
        ll2.pushHd(6);
        assertEquals(4, ll2.length());
        assertEquals(3, ll.length());
        assertEquals(6, ll2.getHd());
        assertEquals(5, ll.getHd());
        ll.pushHd(1);
        assertEquals(4, ll2.length());
        assertEquals(4, ll.length());
        assertEquals(6, ll2.getHd());
        assertEquals(1, ll.getHd());
    }

    private <T> T wrapAsUnchecked(ThrowingSupplier<? extends T> f) {
        try {
            return f.get();
        } catch (Throwable e) {
            throw (e instanceof RuntimeException ?
                    (RuntimeException)e : new RuntimeException(e));
        }
    }
}