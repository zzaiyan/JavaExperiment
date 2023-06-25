package exp;

import java.util.Scanner;

public class Exp1_6 {
    public static boolean isPalindromic(String str) {
        String rStr = new StringBuffer(str).reverse().toString();
        return str.equals(rStr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        System.out.println(x + (isPalindromic(x) ? " 是" : " 不是") + "回文数");
    }
}
