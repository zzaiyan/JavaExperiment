package exp;

import java.util.Random;

public class Exp1_8 {
    public static void swap(int[] ele, int a, int b) {
        int tmp = ele[a];
        ele[a] = ele[b];
        ele[b] = tmp;
    }

    public static int bubble(int[] ele, int lo, int hi) {
        int last = lo;
        while (++lo < hi)
            if (ele[lo - 1] > ele[lo]) {
                last = lo;
                swap(ele, lo - 1, lo);
            }
        return last;  // return hi - 1;
    }

    public static void bubbleSort(int[] ele, int lo, int hi) {
        while (lo < (hi = bubble(ele, lo, hi)))
            ;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
            System.out.print(arr[i] + "\t");
        }
        System.out.println(" ");
        bubbleSort(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(" ");
    }
}
