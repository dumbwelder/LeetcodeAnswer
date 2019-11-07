package Literature.Test6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            count += val;
            max = Math.max(val, max);
        }
        count -= max * (n - 1);
        count = (int) Math.ceil((double) count / (n - 1));
        System.out.println(count + max);
    }
}