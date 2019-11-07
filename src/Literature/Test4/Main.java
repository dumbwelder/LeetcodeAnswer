package Literature.Test4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int res = 0;

        while (arr[0] != 0) {
            int flag = 0;
            for (int i = 1; i < n; i++) {
                arr[i] -= 1;
                if (arr[i] < arr[0]) {
                    flag = i;
                }
            }
            int temp = arr[flag];
            arr[flag] = arr[0];
            arr[0] = temp;
            res++;
        }
        System.out.println(res + arr[n - 1]);
    }
}