package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P4OnlyCS;

public class Student {
    private String _name;
    private int _numTicks;
    // In a real system there would be other attributes as well

    public Student(String name, int numTicks) {
        _name = name;
        _numTicks = numTicks;
    }

    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }

    public int getNumTicks() {
        return _numTicks;
    }
    public void setNumTicks(int numTicks) {
        if (numTicks < 0 ||  numTicks > 20)
            throw new IllegalArgumentException("Ticks must be 0 to 20");
        _numTicks = numTicks;
    }

    public boolean pass() {
        // The CS department by default teaches CS students
        // who need all 20 ticks
        return getNumTicks() == 20;
    }
}
