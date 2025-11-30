package Q4P2.PackageA;

public class ClassA2 extends ClassA {
    public static void main(String[] args) {
        // System.out.println(privateAttr); // Error (subclass can't access private attr)
        System.out.println(packageAttr);    // OK (same pkg)
        System.out.println(protectedAttr);  // OK (subclass can access protected)
    }
}
