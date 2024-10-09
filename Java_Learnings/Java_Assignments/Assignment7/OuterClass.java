package Java_Assignments.Assignment7;

// InnerClassHierarchy.java
public class OuterClass {
    public class InnerClass {
        private String name;

        public InnerClass(String name) {
            this.name = name;
            System.out.println("Inner class with name: " + name);
        }
    }
}

