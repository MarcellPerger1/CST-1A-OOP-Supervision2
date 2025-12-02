package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P5;

public class Star implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw: STAR");
    }

    @Override
    public String getType() {
        return "Star";
    }
}
