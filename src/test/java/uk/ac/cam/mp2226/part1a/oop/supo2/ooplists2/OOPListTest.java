package uk.ac.cam.mp2226.part1a.oop.supo2.ooplists2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OOPListTest {
    @ParameterizedTest
    @MethodSource("getTestObjects")
    void test(OOPList list) {
        assertEquals(0, list.length());
        assertThrows(IndexOutOfBoundsException.class, list::popLast);
        assertThrows(IndexOutOfBoundsException.class, list::last);
        assertThrows(IndexOutOfBoundsException.class, () -> list.nth(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.nth(1));
        list.addLast(3);
        // [3]
        assertEquals(1, list.length());
        assertEquals(3, list.last());
        assertEquals(3, list.nth(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.nth(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.nth(1));
        list.addLast(7);
        // [3, 7]
        assertEquals(7, list.last());
        assertEquals(3, list.nth(0));
        assertEquals(7, list.nth(1));
        list.addLast(5);
        // [3, 7, 5]
        assertEquals(3, list.length());
        assertEquals(3, list.nth(0));
        assertEquals(7, list.nth(1));
        assertEquals(5, list.popLast());
        // [3, 7]
        assertEquals(2, list.length());
        for (int i = 0; i < 20; i++) {
            // test growing of ArrayList
            list.addLast(i);
        }
        // [3, 7, 0, ..., 19]
        assertEquals(22, list.length());
        assertEquals(19, list.last());
        for (int i = 19; i >= 0; i--) {
            assertEquals(i, list.popLast());
        }
        assertEquals(7, list.popLast());
        assertEquals(3, list.popLast());
        assertEquals(0, list.length());
        assertThrows(IndexOutOfBoundsException.class, list::popLast);
        assertThrows(IndexOutOfBoundsException.class, list::last);
        assertThrows(IndexOutOfBoundsException.class, () -> list.nth(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.nth(1));
    }

    static Stream<Arguments> getTestObjects() {
        return Stream.of(
                Arguments.of(new OOPLinkedList()),
                Arguments.of(new OOPArrayList())
        );
    }
}
