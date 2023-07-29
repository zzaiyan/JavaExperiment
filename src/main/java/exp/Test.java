package exp;

import java.util.Collections;

public class Test {
    public static void main(String[] args) {
//        Parent p = new Parent(1);
//        p.print();
//        System.out.println(p.getName());

        Child c = new Child(1);
        c.print();
        System.out.println(c.getName());
        System.out.println(c.name);
//        int[] arr = new int[10];
//        Collections.sort(arr);

        Parent p = c;
        p.print();
        System.out.println(p.getName());
        System.out.println(p.name);

    }
}

class Parent {
    int m = 0;
    String name = "Parent's Name";

    public Parent(int x) {
        System.out.println("Parent's constructor");
    }

    public void print() {
        System.out.println("Parent");
    }

    public String getName() {
        return this.name;
    }
}

class Child extends Parent {
    String name = "Child's Name";
    double m = 1.5;

    public Child(int x) {
        super(x);
        System.out.println("Child's constructor");
    }

    public String getName() {
        return this.name;
    }

    public void print() {
        System.out.println("Child");
    }
}
