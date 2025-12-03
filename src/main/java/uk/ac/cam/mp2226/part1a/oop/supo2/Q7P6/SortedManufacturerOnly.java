package uk.ac.cam.mp2226.part1a.oop.supo2.Q7P6;

import java.util.TreeSet;
import java.util.stream.Stream;

public class SortedManufacturerOnly {
    private TreeSet<Car> cars;

    public SortedManufacturerOnly() {
        // Sorted by natural (just manufacturer) ordering
        cars = new TreeSet<>();
    }

    public void add(Car c) {
        cars.add(c);
    }
    // Can add other modification method that just delegate to the cars.*

    public Stream<Car> stream() {
        return cars.stream();
    }
    // can delegate any other iteration methods to cars as well
}
