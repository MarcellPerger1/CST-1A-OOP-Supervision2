package Q4P2.PackageA;

public class ClassA {
    private static int privateAttr;
    static int packageAttr;
    protected static int protectedAttr;

    public static void main(String[] args) {
        // Same class so can access everything
        System.out.println(privateAttr);    // OK
        System.out.println(packageAttr);    // OK
        System.out.println(protectedAttr);  // OK
    }
}
