package Java_Assignments.Assignment7;

public class SecondOuterClass extends OuterClass {
    public class SecondInnerClass extends InnerClass {
        public SecondInnerClass(OuterClass outer, String name) {
            outer.super(name);
            System.out.println("SecondInnerClass created.");
        }
    }
}
