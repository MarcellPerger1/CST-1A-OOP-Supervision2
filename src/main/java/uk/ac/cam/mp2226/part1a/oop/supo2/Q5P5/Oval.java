package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P5;

public class Oval implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw: OVAL");
    }

    @Override
    public String getType() {
        return "Oval";
    }
}
