package exp;

public class Exp2_2 {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook();
        Notebook nb2 = new Notebook("联想", 200);

        Tester.test(nb1);
        Tester.test(nb2);
    }
}

class Notebook {
    public String brand;
    public int status;

    public Notebook() {
        this.brand = "Undefined";
        this.status = -1;
    }

    public Notebook(String b, int s) {
        this.brand = b;
        this.status = s;
    }
}

class Tester {
    public static void test(Notebook nb) {
        System.out.println("Testing.");
        System.out.println("品牌 = " + nb.brand);
        System.out.println("状态 = " + nb.status);
    }
}