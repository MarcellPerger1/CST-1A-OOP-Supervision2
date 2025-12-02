package uk.ac.cam.mp2226.part1a.oop.supo2.ooplists;

// Fine, no generics :(
public class OOPLinkedList {
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

        public int nth(int n) {
            return n == 0 ? value
                    : next == null
                    ? throwAsInt(new IndexOutOfBoundsException())
                    : next.nth(n - 1);
        }
    }

    protected Node head;

    public OOPLinkedList() {
        head = null;
    }

    public int getHd() {
        if (head == null)
            throw new IllegalStateException("empty OOPLinkedList has no head");
        return head.value;
    }

    public int popHd() {
        int h = getHd();
        head = head.next;
        return h;
    }

    public void pushHd(int v) {
        head = new Node(v, head);
    }

    public int length() {
        return head == null ? 0 : head.length();
    }

    public int nth(int n) {
        return head == null ?
                throwAsInt(new IndexOutOfBoundsException())
                : head.nth(n);
    }

    // Technically, this is `unit -> 'a` but 'Do not use generics'.
    // Its purpose it to `throw` in expressions where a 'a is expected.
    // It is required because `throw` is not an expression but a
    // statement in Java (reason 2 for me disliking Java)
    private static int throwAsInt(RuntimeException ex) {
        throw ex;
    }
}
