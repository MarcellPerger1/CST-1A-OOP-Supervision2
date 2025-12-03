package uk.ac.cam.mp2226.part1a.oop.supo2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NamesAndPercentagesTest {
    @Test
    void sortedNames() {
        NamesAndPercentages np = new NamesAndPercentages();
        np.addMark("Jim", 95);
        np.addMark("Jerry", 56);
        np.addMark("Johnathan", 71);
        np.addMark("Jeremy", 67);
        assertIterableEquals(
                List.of("Jeremy", "Jerry", "Jim", "Johnathan"),
                np.sortedNames());
    }

    @Test
    void topPPercent() {
        NamesAndPercentages np = new NamesAndPercentages();
        np.addMark("Jim", 95);
        np.addMark("Jerry", 56);
        np.addMark("Johnathan", 71);
        np.addMark("Jeremy", 67);
        np.addMark("Jon", 51);
        assertIterableEquals(
                List.of("Jim", "Johnathan"),
                np.topPPercent(40)
        );
    }

    @Test
    void medianMark() {
        {  // odd number of items
            NamesAndPercentages np = new NamesAndPercentages();
            np.addMark("Jim", 95);
            np.addMark("Jerry", 56);
            np.addMark("Johnathan", 71);
            np.addMark("Jeremy", 67);
            np.addMark("Jon", 51);
            assertEquals(67, np.medianMark());
        }
        {  // even number of items
            NamesAndPercentages np = new NamesAndPercentages();
            np.addMark("Jim", 95);
            np.addMark("Johnathan", 71);
            np.addMark("Jeremy", 67);
            np.addMark("Jon", 51);
            assertEquals(69, np.medianMark());
        }
    }
}