package Tencent.Test4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[][] res = new int[n][n];
        int max= 0;
        for (int i = 0; i < n; i++) {
            res[i][i] = arr[i] * arr[i];
            max = max>res[i][i]?max:res[i][i];
        }
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int sum = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
                sum+=arr[j];
                res[i][j] = min *sum;
                max = max>res[i][j]?max:res[i][j];
            }
        }
        System.out.println(max);
    }
}
