package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P5;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw: CIRCLE");
    }

    @Override
    public String getType() {
        return "Circle";
    }
}
