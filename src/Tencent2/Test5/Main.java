package Tencent2.Test5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Set<Integer> setSum = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (set1.contains(val)) {
                set1.remove(val);
            } else {
                set1.add(val);
            }
        }
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (set2.contains(val)) {
                set2.remove(val);
            } else {
                set2.add(val);
            }
        }
        int res = 0;
        for (int i : set1) {
            for (int j : set2) {
                int sum = i + j;
                res = res ^ sum;
            }
        }
        System.out.println(res);
    }
}
/*
5
1 2 1 0 0
1 2 3 0 0
 */