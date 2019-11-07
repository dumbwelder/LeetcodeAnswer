package duxiaoman.Test1;

import java.util.Scanner;

public class Main {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] block = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            block[i] = sc.nextInt();
            count += block[i];
        }
        findMin(block, 0, count);
        System.out.println(res);
    }

    private static void findMin(int[] block, int times, int count) {
        if (count == 0) {
            res = Math.min(times, res);
        } else if (times < res) {
            for (int i = 0; i <= block.length; i++) {
                boolean flag1 = false;
                boolean flag2 = false;
                boolean flag3 = false;
                if (block[i - 1] > 0) {
                    block[i - 1]--;
                    count--;
                    flag1 = true;
                }
                if (2 * i - 1 < block.length && block[2 * i - 1] > 0) {
                    block[2 * i - 1]--;
                    count--;
                    flag2 = true;
                }
                if (2 * i < block.length && block[2 * i] > 0) {
                    block[2 * i]--;
                    count--;
                    flag3 = true;
                }
                if (flag1 || flag2 || flag3) {
                    times++;
                    findMin(block, times, count);
                    times--;

                    if (flag1) {
                        block[i - 1]++;
                        count++;
                    }
                    if (flag2) {
                        block[2 * i - 1]++;
                        count++;
                    }
                    if (flag3) {
                        block[2 * i]++;
                        count++;
                    }
                }
            }
        }
    }

}
/*
5
1 2 3 4 5
 */
