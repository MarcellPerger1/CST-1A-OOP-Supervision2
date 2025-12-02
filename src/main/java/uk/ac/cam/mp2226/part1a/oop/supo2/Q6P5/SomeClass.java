package uk.ac.cam.mp2226.part1a.oop.supo2.Q6P5;

public class SomeClass extends SomeOtherClass implements Cloneable {
    private int[] mData;

    SomeClass() {
        super();
        mData = new int[4];
    }

    public Object clone() {
        SomeClass sc = new SomeClass();
        sc.mData = mData.clone();
        return sc;
    }
}
