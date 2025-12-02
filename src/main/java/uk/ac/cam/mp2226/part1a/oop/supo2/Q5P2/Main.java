package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Base> objects = List.of(
                new Base(),
                new SubA(),
                new SubA(),
                new SubB(),
                new Base(),
                new SubB()
        );
        for(Base o : objects) {
            // Dynamically dispatches to the correct method based on
            // the runtime (rather than compile-time) type of `o`
            o.method();
        }
    }
}
