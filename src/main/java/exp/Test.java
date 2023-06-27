package exp;

public class Test {
    public static void main(String[] args) {
        Parent p = new Parent(1);
        p.print();
        p = new Child(1);
        p.print();

        String s1 = "hello" + "world";
        String s2 = new String(s1);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

class Parent {
    int m;

    public Parent(int x) {
        System.out.println("Parent's constructor");
    }

    public void print() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    double m;

    public Child(int x) {
        super(x);
        System.out.println("Child's constructor");
    }

    public void print() {
        System.out.println("Child");
    }
}
