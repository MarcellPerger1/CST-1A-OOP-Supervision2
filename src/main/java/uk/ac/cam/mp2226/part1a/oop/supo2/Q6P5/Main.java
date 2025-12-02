package uk.ac.cam.mp2226.part1a.oop.supo2.Q6P5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SomeClass sc = new SomeClass();
        // Would in reality be set by some methods or something.
        sc.arr[0] = 7;
        // This doesn't clone .arr, it just sets it to the initial value
        SomeClass sc2 = (SomeClass) sc.clone();
        // Prints [7, 0, 0, 0, 0]
        System.out.println("sc.arr = " + Arrays.toString(sc.arr));
        // Prints [0, 0, 0, 0, 0], should be [7, 0, 0, 0, 0]
        System.out.println("sc2.arr = " + Arrays.toString(sc2.arr));
    }
}
