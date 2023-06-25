package exp;

public class Exp2_3 {
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);
        Rational r3 = r1.add(r2); // r3 = 5/4
        Rational r4 = r1.subtract(r2); // r4 = -1/4
        Rational r5 = r1.multiply(r2); // r5 = 3/8
        Rational r6 = r1.divide(r2); // r6 = 2/3

        System.out.println(r1 + " + " + r2 + " = " + r3); // 输出 5/4
        System.out.println(r1 + " - " + r2 + " = " + r4); // 输出 -1/4
        System.out.println(r1 + " * " + r2 + " = " + r5); // 输出 3/8
        System.out.println(r1 + " / " + r2 + " = " + r6); // 输出 2/3
    }
}

class Rational {
    private int a; // 分子
    private int b; // 分母

    // 构造函数
    public Rational(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("分母不能为0");
        }
        if (a == 0) {
            this.a = 0;
            this.b = 1;
        } else {
            int gcd = gcd(Math.abs(a), Math.abs(b));
            this.a = a / gcd;
            this.b = b / gcd;
            if (this.b < 0) { // 将符号分配给分子
                this.a *= -1;
                this.b *= -1;
            }
        }
    }

    // 求最大公约数
    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    // 获取分子
    public int getA() {
        return a;
    }

    // 获取分母
    public int getB() {
        return b;
    }

    // 加法运算
    public Rational add(Rational r) {
        int newA = this.a * r.b + r.a * this.b;
        int newB = this.b * r.b;
        return new Rational(newA, newB);
    }

    // 减法运算
    public Rational subtract(Rational r) {
        int newA = this.a * r.b - r.a * this.b;
        int newB = this.b * r.b;
        return new Rational(newA, newB);
    }

    // 乘法运算
    public Rational multiply(Rational r) {
        int newA = this.a * r.a;
        int newB = this.b * r.b;
        return new Rational(newA, newB);
    }

    // 除法运算
    public Rational divide(Rational r) {
        int newA = this.a * r.b;
        int newB = this.b * r.a;
        return new Rational(newA, newB);
    }

    // 用于print
    public String toString() {
        if (b == 1) {
            return Integer.toString(a);
        } else {
            return a + "/" + b;
        }
    }
}
