package uk.ac.cam.mp2226.part1a.oop.supo2.ooplists;

public class OOPLazySortedLinkedList extends OOPSortedLinkedList {
    // It doesn't really make sense in terms of the implementation
    // for this to inherit from OOPSortedLinkedList as the
    // implementation doesn't share any code.
    // In reality, I would have OOPEagerSortedLL and OOPLazySortedLL
    //  to both implement a OOPSortedLL interface (or extend
    //  that abstract class)

    private boolean isSorted = true;  // Empty = sorted

    @Override
    public void pushHd(int v) {
        isSorted = false;
        // Inheriting from OOPSortedLL is bad design so we need to bypass
        // its eager sorting and code the original pushHd
        head = new Node(v, head);
    }

    @Override
    public int getHd() {
        sortIfNeeded();
        return super.getHd();
    }

    @Override
    public int nth(int n) {
        sortIfNeeded();
        return super.nth(n);
    }

    @Override
    public int popHd() {
        sortIfNeeded();
        // Don't need to resort - rest is still sorted
        return super.popHd();
    }

    protected void sortIfNeeded() {
        if(!isSorted) {
            sort();
            isSorted = true;
        }
    }
    // More efficient sorting algorithms are available as this
    // is effectively an insertion sort
    protected void sort() {
        // I can't be bothered to write a LL sorting algorithm
        // so I'll abuse already-implemented eager OOPSortedLL
        OOPSortedLinkedList eager = new OOPSortedLinkedList();
        Node curr = head;
        while (curr != null) {
            eager.pushHd(curr.value);  // inserts into correct place
            curr = curr.next;
        }
        head = eager.head;  // exploits same Node type
    }
}
