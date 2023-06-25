package exp;

public class Exp2_7 {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        obj.publicMethod();    // 可以访问公共方法
        obj.defaultMethod();   // 可以访问默认访问权限的方法
        obj.protectedMethod(); // 可以访问受保护访问权限的方法（同一个包中）
        // obj.privateMethod(); // 无法访问私有访问权限的方法
    }
}

class TestClass {
    public void publicMethod() {
        System.out.println("这是一个公共方法。");
    }

    void defaultMethod() {
        System.out.println("这是一个默认访问权限的方法。");
    }

    protected void protectedMethod() {
        System.out.println("这是一个受保护访问权限的方法。");
    }

    private void privateMethod() {
        System.out.println("这是一个私有访问权限的方法。");
    }
}

