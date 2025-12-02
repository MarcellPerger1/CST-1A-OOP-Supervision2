package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Circle(),
                new Square(),
                new Star(),
                new Oval(),
                new Square()
        );
        for (Shape s : shapes) {
            // Can check the type like so:
            if (s.getType().equals("Circle")) {
                Circle c = (Circle) s;
                // and then do whatever we want with it:
                c.draw();
            }
        }
    }
}
