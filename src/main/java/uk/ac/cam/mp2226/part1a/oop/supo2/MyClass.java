package uk.ac.cam.mp2226.part1a.oop.supo2;

public class MyClass implements Cloneable {
    private String mName;
    private int[] mData;

    // Copy constructor
    public MyClass(MyClass toCopy) {
        this.mName = toCopy.mName;
        this.mData = toCopy.mData.clone();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyClass cloned = (MyClass) super.clone();
        cloned.mData = cloned.mData.clone();
        return cloned;
    }
}
