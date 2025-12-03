package uk.ac.cam.mp2226.part1a.oop.supo2.Q7P6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortedManufacturerOnlyTest {
    @Test
    void testOrder() {
        SortedManufacturerOnly cars = new SortedManufacturerOnly();
        cars.add(new Car("Peugeot", 2));
        cars.add(new Car("Renault", 5));
        cars.add(new Car("Ford", 7));
        cars.add(new Car("Nissan", 1));
        assertIterableEquals(
                List.of(new Car("Ford", 7),
                        new Car("Nissan", 1),
                        new Car("Peugeot", 2),
                        new Car("Renault", 5)),
                cars.stream().toList()
        );
    }
}
