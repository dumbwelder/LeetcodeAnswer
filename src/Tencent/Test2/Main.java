package Tencent.Test2;

import java.util.Scanner;

/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case              int a = in.nextInt();
      int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int countBox = 0;
        int countKey = 0;

        for (int i = 0; i < m; i++) {
            if (in.nextInt()%2==1){
                countBox++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (in.nextInt()%2==1){
                countKey++;
            }
        }
        int result = Math.min(countBox,n-countKey)+ Math.min(m-countBox,countKey);
        System.out.println(result);

    }
}
