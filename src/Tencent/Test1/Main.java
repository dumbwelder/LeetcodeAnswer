package Tencent.Test1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n <= 0) System.out.println(0);
            int a[] = new int[n];
            int b[] = new int[n];
            int c[] = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
                c[i] = a[i] - b[i];
                count += n * b[i] - a[i];
            }
            Arrays.sort(c);
            for (int i = 1; i <= n; i++) {
                count += c[n - i] * i;
            }
            System.out.println(count);
        }
    }
}
