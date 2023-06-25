package exp;

public class Exp1_4 {
    public static void fun(int layer) {
        for (int y = 0; y < layer; y++) {
            for (int x = 0; x < 2 * layer - 1; x++) {
                if (x == layer - y - 1 || x == layer + y - 1 || y == layer - 1)
                    System.out.print('*');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        fun(7);
    }
}
