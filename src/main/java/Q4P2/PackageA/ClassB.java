package Q4P2.PackageA;

public class ClassB {
    public static void main(String[] args) {
        //System.out.println(ClassA.privateAttr); // Error (other class can't access private)
        System.out.println(ClassA.packageAttr);   // OK (same pkg)
        System.out.println(ClassA.protectedAttr); // OK (same pkg, so can access protected)
    }
}
