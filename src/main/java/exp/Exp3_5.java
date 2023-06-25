package exp;

public class Exp3_5 {
    public static void main(String[] args) {
        Division.divide(39, 0);
        System.out.println("主程序退出。");
    }

}

class Division {
    public static void divide(int a, int b) {
        try {
            int c = a / b;
            System.out.println("除法完成。"); // 如果没有异常，这句话可以执行到
        } catch (ArithmeticException e) {
            System.out.println("异常信息：" + e.getMessage());
            System.out.println("除数不能为0。");
        } finally {
            System.out.println("打印完成。");
        }
    }
}