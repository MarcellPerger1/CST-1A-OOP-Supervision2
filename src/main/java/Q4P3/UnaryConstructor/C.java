package Q4P3.UnaryConstructor;

public class C extends B {
    // Need to add this code to correctly call B's constructor  which will
    // then call A's constructor
    public C(int arg) {
        super(arg);
    }
}
