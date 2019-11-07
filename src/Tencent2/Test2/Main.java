package Tencent2.Test2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int count = in.nextInt();
            int value = in.nextInt();
            int index = 0;
            while (index < list.size() && list.get(index) < value) {
                index++;
            }
            for (int j = 0; j < count; j++) {
                list.add(index,value);
            }
        }
        int m = list.size();
        Integer[] arr = new Integer[m];
        arr = list.toArray(arr);
        int res = 0;
        for (int i = 0, j = m - 1; i < j; i++, j--) {
            res = Math.max(res, arr[i] + arr[j]);
        }
        System.out.println(res);
    }
}
/*
3
1 8
2 5
1 2
 */