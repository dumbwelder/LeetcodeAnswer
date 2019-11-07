package Tencent2.Test3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++) {
            n = in.nextInt();
            int[] arr = new int[n];
            int[] res = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
                sum += arr[j];
            }
            Arrays.sort(arr);
            res[0] = arr[n-1];
            for (int j = n - 2; j >= 0; j--) {
                        
            }


        }
    }


}
/*
2
4
5 9 4 7
8
9 13 18 10 12 4 18 3
 */