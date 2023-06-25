package exp;

import java.util.Scanner;

public class Exp1_5 {
    public static boolean isSxh(int number) {
        int origin = number;
        int numDigits = String.valueOf(number).length();
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numDigits);
            number /= 10;
        }
        return sum == origin;
    }

    public static void get99(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public static void Bybj() {
        int totalMoney = 100, totalChicken = 100;
        for (int i = 0; i <= totalMoney / 5; i++) {
            for (int j = 0; j <= totalMoney / 3; j++) {
                int k = totalChicken - i - j;

                if (i * 5 + j * 3 + k / 3 == totalMoney && k % 3 == 0) {
                    System.out.println("公鸡：" + i + "，母鸡：" + j + "，小鸡：" + k);
                }
            }
        }
    }

    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i < x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("水仙花数：");
        for (int x = 100, cnt = 0; x < 1000; x++) {
            if (isSxh(x)) {
                System.out.print((cnt == 0 ? "" : ", ") + x);
                cnt++;
            }
        }
        System.out.println(" ");
        System.out.println("乘法表：");
        get99(9);
        Scanner sc = new Scanner(System.in);
//        int a=sc.nextInt(), b=sc.nextInt();
        int a = 108, b = 64;
        System.out.format("gcd(%d, %d) = %d\n", a, b, gcd(a, b));
        System.out.println("百元百鸡问题：");
        Bybj();
        System.out.println("100以内质数表：");
        for (int x = 2, cnt = 0; x < 100; x++) {
            if (isPrime(x)) {
                System.out.print((cnt == 0 ? "" : ", ") + x);
                cnt++;
            }
        }
        System.out.println(" ");
    }
}
