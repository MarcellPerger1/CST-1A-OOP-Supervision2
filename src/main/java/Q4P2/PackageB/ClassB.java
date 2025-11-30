package Q4P2.PackageB;

import Q4P2.PackageA.ClassA;

public class ClassB {
    public static void main(String[] args) {
        // System.out.println(ClassA.privateAttr);   // Error (other pkg, unrelated class)
        // System.out.println(ClassA.packageAttr);   // Error (other pkg, unrelated class)
        // System.out.println(ClassA.protectedAttr); // Error (other pkg, unrelated class)
    }
}
