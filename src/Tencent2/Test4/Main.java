package Tencent2.Test4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        int index = 0;
        while (k > 0) {
            if (arr[index] != sum) {
                System.out.println(arr[index] - sum);
                sum = arr[index];
                k--;
            } else if (arr[index] == arr[n - 1]) {
                System.out.println(0);
                k--;
            }
            index = index < n - 1 ? index + 1 : index;
        }
    }
}
/*
7 8
0 0 0 0 0 0 0 0
 */