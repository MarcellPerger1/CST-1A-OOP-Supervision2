package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P4WithNS;

public class NSStudent extends Student {
    public NSStudent(String name, int numTicks) {
        super(name, numTicks);
    }

    @Override
    public boolean pass() {
        return getNumTicks() >= 10;
    }
}
