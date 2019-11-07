package Tencent.Test3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int max = m;
        int count = 1;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            while (a[i] > 0) {
                if (m <= a[i]) {
                    a[i] = a[i] - m;
                    count++;
                    m = max;
                } else if (m > a[i]) {
                    a[i] = 0;
                    m = m - a[i];
                }
            }
            if (m==max&&i!=n-1){
                count++;
            }

        }
        System.out.println(count);

    }
}
