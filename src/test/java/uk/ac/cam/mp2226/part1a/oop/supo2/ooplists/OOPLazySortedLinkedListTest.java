package uk.ac.cam.mp2226.part1a.oop.supo2.ooplists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OOPLazySortedLinkedListTest {
    @Test
    void test() {
        OOPLazySortedLinkedList ll = new OOPLazySortedLinkedList();
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
        // 2 :: 7 :: 9 :: []
        assertEquals(9, ll.nth(2));
        assertEquals(7, ll.nth(1));
        assertEquals(2, ll.nth(0));
        assertEquals(3, ll.length());
        assertEquals(2, ll.popHd());
        ll.pushHd(8);
        // 7 :: 8 :: 9 :: []
        assertEquals(3, ll.length());
        assertEquals(7, ll.getHd());
        assertEquals(7, ll.nth(0));
        assertEquals(8, ll.nth(1));
        assertEquals(9, ll.nth(2));
        assertEquals(7, ll.popHd());
        // 8 :: 9 :: []
        ll.pushHd(3);
        // 3 :: 8 :: 9 :: []
        assertEquals(3, ll.popHd());
        assertEquals(8, ll.popHd());
        // 9 :: []
        assertEquals(9, ll.nth(0));
        assertThrows(IndexOutOfBoundsException.class, () -> ll.nth(1));
        assertEquals(9, ll.popHd());
        // []
        assertEquals(0, ll.length());
        assertThrows(IllegalStateException.class, ll::popHd);
        assertThrows(IllegalStateException.class, ll::getHd);
    }
}
