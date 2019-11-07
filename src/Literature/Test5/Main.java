package Literature.Test5;

import java.util.Scanner;

public class Main {
    static int[] arr;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        arr = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr[in.nextInt()-1] = in.nextInt();
            cal();
        }

    }

    private static void cal() {
        int count = n;
        int[] arr1 = arr.clone();
        while (count > 0) {
            for (int i = 0; i < (1 << count - 1); i++) {
                arr1[i] = (arr1[i * 2] | arr1[i * 2 + 1]);
            }
            count--;
            for (int i = 0; i < (1 << count - 1); i++) {
                arr1[i] = (arr1[i * 2] ^ arr1[i * 2 + 1]);
            }
            count--;
        }
        System.out.println(arr1[0]);
    }
}