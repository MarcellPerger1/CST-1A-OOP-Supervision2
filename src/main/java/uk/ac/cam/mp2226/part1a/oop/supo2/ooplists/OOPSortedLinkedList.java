package uk.ac.cam.mp2226.part1a.oop.supo2.ooplists;

public class OOPSortedLinkedList extends OOPLinkedList {
    // The naming really doesn't make sense any more as it won't be
    // placed at the head. When I designed the OOPLinkedList earlier
    // I didn't think that there would be a sorted subclass
    @Override
    public void pushHd(int v) {
        head = pushFrom(head, v);
    }

    // I would have liked to define a new Node class and implement some of
    // these extra methods on that but attribute types cannot be overridden,
    // so this is the best that we can do
    protected Node pushFrom(Node n, int v) {
        if(n == null) return new Node(v, null);
        if(v <= n.value) return new Node(v, n);
        /*v > n.value*/ n.next = pushFrom(n.next, v);  // not in correct place yet
        return n;
    }
}
