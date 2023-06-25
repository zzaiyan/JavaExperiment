package exp;

public class Test {
    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
//            System.out.println("finally");
        }
        output += "4";
    }

    public static void main(String[] args) {
        foo(0);
        foo(1);
        System.out.println(output);

//        int i = 100;
        byte b = 20;
        char c = 'c';
        var x = b + c;
        int i = b + c;
        int i2 = 'c' + 1000;
        System.out.println(i2);
    }
}
