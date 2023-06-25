package exp;

public class Exp1_2 {
    public static void main(String[] args) {
        int[] list = {2, 6, 3, 8, 4, 9, 7};
        for (int i = list.length - 1; i >= 0; i--) {
            System.out.print(list[i] + (i == 0 ? "" : ", "));
        }
    }
}
