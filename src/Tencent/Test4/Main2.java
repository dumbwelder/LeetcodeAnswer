package Tencent.Test4;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[][] res = new int[n][n];
        int max = 0;
        int minValue = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (minValue > arr[end]) {
                minValue = arr[end];
            }
            sum = sum + arr[end];
            if (max < minValue * sum) {
                max = minValue * sum;
            }
        }

        System.out.println(max);
    }
}
