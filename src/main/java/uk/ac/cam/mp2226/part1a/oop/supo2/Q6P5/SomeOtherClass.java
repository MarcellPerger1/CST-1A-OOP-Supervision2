package uk.ac.cam.mp2226.part1a.oop.supo2.Q6P5;

public class SomeOtherClass implements Cloneable {
    // in reality, it would be private with getters & setters
    // but this is just some quick-and-dirty example code
    public int[] arr;

    public SomeOtherClass() {
        arr = new int[5];
    }

    @Override
    public Object clone() {
        SomeOtherClass o;
        try {
            o = (SomeOtherClass) super.clone();
        } catch (CloneNotSupportedException e) {
            // Why does did this need to be a check exception.
            // It just makes life inconvenient. If we support clone,
            // our subclasses, MUST, by the Liskov substitution
            // principle, also be cloneable! So since super.clone()
            // will only result in subclasses of us, then it should
            // never be raising CloneNotSupportedException!
            // But perhaps more importantly, if clone is not supported,
            // just don't implement the interface! Simple!
            // But Java had to be Java and make it inconvenient
            //  (another reason why cloning is badly implemented,
            //   and consequently, another reason why I dislike Java)
            throw new RuntimeException(e);
        }
        o.arr = o.arr.clone();
        return o;
    }
}
