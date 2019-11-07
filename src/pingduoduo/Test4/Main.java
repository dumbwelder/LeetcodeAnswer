package pingduoduo.Test4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            calSum(arr, n, m);
        }
    }

    private static void calSum(int[] arr, int n, int m) {
        int[] res = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.add(arr[i])) {
                res[i + 1] = res[i] + 1;
            } else {
                res[i + 1] = res[i];
            }
        }
        System.out.println(res[n]);
    }

}
/*
1
5 1
1 2 3 1 2 
*/