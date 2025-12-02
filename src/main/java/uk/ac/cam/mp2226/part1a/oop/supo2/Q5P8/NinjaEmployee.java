package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P8;

// Inherit functionality from Employee...
public class NinjaEmployee extends Employee implements INinja {
    // (Protected so subclasses can also access its ninja stuff)
    protected INinja ninjaPersona;

    public NinjaEmployee(String name) {
        super(name);
        ninjaPersona = new Ninja();
    }

    // ...and delegate functionality to inner composed ninja object.
    @Override
    public void doNinjaStuff() {
        ninjaPersona.doNinjaStuff();
    }
}
