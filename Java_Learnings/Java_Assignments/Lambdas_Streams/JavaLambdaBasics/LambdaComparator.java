package Java_Assignments.Lambdas_Streams.JavaLambdaBasics;

import java.util.*;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class LambdaComparator {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();
        // Adding Products
        list.add(new Product(1, "HP Laptop", 25000f));
        list.add(new Product(3, "Keyboard", 300f));
        list.add(new Product(2, "Dell Mouse", 150f));

        System.out.println("Sorting on the basis of name...");

        // Implementing lambda expression
        Collections.sort(list, (p1, p2) -> p1.name.compareTo(p2.name));
        for (Product p : list) {
            System.out.println(p.id + " " + p.name + " " + p.price);
        }
    }
}
