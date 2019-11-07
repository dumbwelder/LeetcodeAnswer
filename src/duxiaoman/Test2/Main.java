package duxiaoman.Test2;

import java.util.Scanner;

public class Main {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
        }
        int totalWeight = 0;
        int res = 0;
        int curCar = 0;
        int left = 0;
        boolean leftFlag = false;
        while (curCar < n) {
            while (curCar < n) {
                int value = totalWeight + weight[curCar];
                if (value <= w) {
                    curCar++;
                    totalWeight = value;
                } else {
                    break;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = left; i < curCar; i++) {
                if (time[i] > 0) {
                    min = Math.min(time[i], min);
                }
            }
            for (int i = left; i < curCar; i++) {
                time[i] -= min;
                if (time[i] == 0) {
                    totalWeight -= weight[i];
                }else if (time[i]>0){
                    if (!leftFlag) {
                        left = i;
                        leftFlag = true;
                    }
                }
            }
            leftFlag = false;
            res += min;
        }
        System.out.println(res + time[n - 1]);
    }
}
/*
4 2
1 1 1 1
2 1 2 2
 */
