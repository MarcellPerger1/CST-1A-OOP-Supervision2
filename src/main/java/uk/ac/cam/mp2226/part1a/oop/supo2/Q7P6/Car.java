package uk.ac.cam.mp2226.part1a.oop.supo2.Q7P6;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String manufacturer;
    private int age;

    public Car(String manufacturer_, int age_) {
        manufacturer = manufacturer_;
        age = age_;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer_) {
        manufacturer = manufacturer_;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age_) {
        age = age_;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car car)) return false;
        return age == car.age && Objects.equals(manufacturer, car.manufacturer);
    }
    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, age);
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return manufacturer.compareTo(o.manufacturer);
    }
}
