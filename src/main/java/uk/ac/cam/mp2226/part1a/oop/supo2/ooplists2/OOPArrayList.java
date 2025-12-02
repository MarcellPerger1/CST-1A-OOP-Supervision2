package uk.ac.cam.mp2226.part1a.oop.supo2.ooplists2;

import java.util.Arrays;

public class OOPArrayList implements OOPList {
    int[] _items;
    int _length;  // section of list actually used

    public OOPArrayList() {
        _items = new int[8];  // Some Initial size
        _length = 0;
    }

    @Override
    public int last() {
        return _items[_length - 1];
    }

    @Override
    public int popLast() {
        int r = last();
        _length--;
        return r;
    }

    @Override
    public void addLast(int v) {
        if (_length == _items.length) {
            growArray();  // If array is full
        }
        // Now will have enough space
        _length++;
        _items[_length - 1] = v;
    }

    protected void growArray() {
        // Exponential growth factor to create O(1) amortized addLast
        _items = Arrays.copyOf(_items, _items.length * 2);
    }

    @Override
    public int length() {
        return _length;
    }

    @Override
    public int nth(int n) {
        if (n < 0 || n >= _length)
            throw new IndexOutOfBoundsException();
        return _items[n];
    }
}
