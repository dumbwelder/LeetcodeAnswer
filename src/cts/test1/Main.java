package cts.test1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<Integer> list = new LinkedList();
        int res = 1;
        while (n / 10 != 0) {
            list.add(n % 10);
            n = n / 10;
        }
        list.add(n);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 9) {
                int val1 = 9;
                int val2 = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        val1 *= 9;
                        val2 = 0;
                    } else {
                        if (list.get(j) != 1) {
                            val1 *= list.get(j) - 1;
                        }
                        val2 *= list.get(j);
                        i = j;
                        break;
                    }
                }
                res *= Math.max(val1, val2);
            }
        }
        if (list.size() == 1) {
            res = n;
        }
        System.out.println(res);
    }
}