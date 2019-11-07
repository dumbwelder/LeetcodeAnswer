package cts.test2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer>[] arr;
    static boolean[] flag;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new LinkedList[n];
        flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            if (size != 0) {
                LinkedList<Integer> list = new LinkedList();
                for (int j = 0; j < size; j++) {
                    list.add(in.nextInt());
                }
                arr[i] = list;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(count(i) + " ");
        }
    }

    private static Integer count(int i) {
        if (arr[i] == null) {
            if (flag[i]) {
                return 0;
            } else {
                flag[i] = true;
                return 1;
            }
        }
        int res = 1;
        for (Integer index : arr[i]) {
            res += count(index - 1);
            arr[index - 1] = null;
        }
        flag[i] = true;
        arr[i] = null;
        return res;
    }
}
/*
3
0
1 1
2 1 2
 */