package uk.ac.cam.mp2226.part1a.oop.supo2.Q4P2.PackageB;

import uk.ac.cam.mp2226.part1a.oop.supo2.Q4P2.PackageA.ClassA;

public class ClassA2 extends ClassA {
    public static void main(String[] args) {
        //System.out.println(privateAttr);    // Error (not the same class)
        //System.out.println(packageAttr);    // Error (not the same pkg)
        System.out.println(protectedAttr);  // OK (it's a subclass)
    }
}
