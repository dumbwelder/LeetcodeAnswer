package webank.Test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n >= 1) {
            int res = 1;
            int value;
            for (int i = 1; i <= n; i++) {
                value = res * i;
                while (value % 10 == 0) {
                    value /= 10;
                }
                res = value % 10;
                if (res<=0){
                    System.out.println(res);
                }
            }
            System.out.println(res);
        }
    }
}
