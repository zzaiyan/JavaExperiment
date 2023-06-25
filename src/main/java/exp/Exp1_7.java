package exp;

public class Exp1_7 {
    public static void main(String[] args) {
        int[] arr = {18, 25, 7, 36, 13, 2, 89, 63};
        int mi = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] > arr[mi])
                mi = i;
        }
        System.out.printf("\nMax = arr[%d] = %d\n", mi, arr[mi]);
    }
}
