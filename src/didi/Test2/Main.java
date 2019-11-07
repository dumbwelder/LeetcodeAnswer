package didi.Test2;
/*
5 1
1 2 3 4 5
5 3
-2 1 -1 -1 -1
5 5
-4 5 -1 -1 -1
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        minSum(n, m, arr);
    }

    private static void minSum(int n, int m, int[] arr) {
        int res = 0;
        int cur = 0;
        int sum = 0;
        int min = 0;
        Queue<Integer> q = new LinkedList<>();
        for (cur = 0; cur < m; cur++) {
            sum += arr[cur];
            if (min >= 0) {
                q.offer(arr[cur]);
                min = arr[cur];
            } else {
                min += arr[cur];
                q.offer(min);
            }
        }
        res = sum;
        while (cur < n) {
            sum += arr[cur];
            sum -= arr[cur - m];
            int val = q.poll();
            if (val < 0) {
                res = Math.min(res, sum + val);
            }
            if (min >= 0) {
                q.offer(arr[cur]);
                min = arr[cur];
            } else {
                min += arr[cur];
                q.offer(min);
            }
            cur++;
        }
        System.out.println(res);
    }
}