package uk.ac.cam.mp2226.part1a.oop.supo2.Q7P6;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SortedManufacturerAge {
    private TreeSet<Car> cars;

    public SortedManufacturerAge() {
        cars = new TreeSet<>(Comparator.comparing(Car::getManufacturer)
                .thenComparing(Car::getAge));
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
