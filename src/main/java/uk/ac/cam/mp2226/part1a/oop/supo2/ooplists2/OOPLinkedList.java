package uk.ac.cam.mp2226.part1a.oop.supo2.ooplists2;


// Still no generics? I dunno, it didn't say anything.
// The design here is slightly different if we're
// trying to have a common interface with array-based
// implementation. The array-based implementation
// adds items to the end so it makes sense to have
// our head be considered the end so we can add items
// there quickly. In that way it's more of a stack but whatever.
// Once again, 'list' is a super-vague concept, so if you
// want something specific, please actually give details.
public class OOPLinkedList implements OOPList {
    protected static class Node {
        // Public here is fine as this is closely intertwined with
        // (and only with) its outer class
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int length() {
            return 1 + (next == null ? 0 : next.length());
        }

        /// Returns the value `n` nodes ahead of this one
        public int advancedBy(int n) {
            return n == 0 ? value
                    : next == null
                    ? throwAsInt(new IndexOutOfBoundsException())
                    : next.advancedBy(n - 1);
        }
    }

    protected Node head;

    public OOPLinkedList() {
        head = null;
    }

    public int last() {
        if (head == null)
            throw new IndexOutOfBoundsException("empty OOPLinkedList has no last item");
        return head.value;
    }

    public int popLast() {
        int h = last();
        head = head.next;
        return h;
    }

    public void addLast(int v) {
        head = new Node(v, head);
    }

    public int length() {
        return head == null ? 0 : head.length();
    }

    public int nth(int n) {
        return head == null ?
                throwAsInt(new IndexOutOfBoundsException())
                // n=0 gives the end of the node-chain
                : head.advancedBy(length() - 1 - n);
    }

    // Technically, this is `unit -> 'a` but 'Do not use generics'.
    // Its purpose it to `throw` in expressions where a 'a is expected.
    // It is required because `throw` is not an expression but a
    // statement in Java (reason 2 for me disliking Java)
    private static int throwAsInt(RuntimeException ex) {
        throw ex;
    }
}
