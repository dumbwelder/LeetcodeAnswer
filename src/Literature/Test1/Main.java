package Literature.Test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            long n = in.nextLong();
            long m = in.nextLong();
            long k = in.nextLong();
            boolean flag = false;
            int res = -1;
            while (!flag) {
                res++;
                flag = ((n * (m - res) <= k) || ((n - res) * m <= k));
            }
            System.out.println(res);
        }
    }
}