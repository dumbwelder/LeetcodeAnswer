package kuaishou.test4;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }
        Arrays.sort(stones);
        while (stones[n - 2] != 0) {
            stones[n - 1] -= stones[n - 2];
            stones[n - 2] = 0;
            if (stones[n - 1] == 0) {
            }
            Arrays.sort(stones);
        }
        System.out.println(stones[n - 1]);
    }
}
/*
6
2 7 4 1 8 1
 */