package webank.Test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 1;
        for (int i = 1; i <= n; i++) {
            int val = i % 1000003;
            res = (res * val) % 1000003;
        }
        System.out.println(res);
    }
}
