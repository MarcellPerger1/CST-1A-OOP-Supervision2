package uk.ac.cam.mp2226.part1a.oop.supo2.Q4P3.UnaryConstructor;

public class C extends B {
    // Need to add this code to correctly call B's constructor  which will
    // then call A's constructor
    public C(int arg) {
        super(arg);
    }
}
