package YiTu.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        List<Integer[]> l = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Integer[] arr = new Integer[n * m];
            for (int j = 0; j < n * m; j++) {
                arr[j] = in.nextInt();
            }
            l.add(arr);
        }
        System.out.println(check(l, k, n, m));

    }

    private static int check(List<Integer[]> l, int k, int n, int m) {
        if (Math.log(k) > m * n) return -1;
        int count = 0;
        Set<String> s = new HashSet<>();
//        for (int i = 0; i <k ; i++) {
//            for (int j = 0; j < ; j++) {
//
//            }
//        }

        return (int) Math.log(k) + 1;
    }
    private void pick(int[] nums, int i, int m, int[] arr) {
        if (m == 0) {
            return ;
        } else {
            for (int j = i; j < nums.length; j++) {
                arr[arr.length-m] = j;
                pick(nums, j + 1, m - 1, arr);
            }
        }
    }
}
