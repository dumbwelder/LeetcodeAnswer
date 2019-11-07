package Tencent2.Test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            judge(n, str);
        }
    }

    private static void judge(int n, String str) {
        if (n < 11 || !str.contains ("8")||(n - str.indexOf('8') < 11)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
/*
3
20
11111111118888888888
3
000
12
111111111111
12
111111111118

 */