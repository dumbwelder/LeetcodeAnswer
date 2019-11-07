package YiTu.Test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int res = change(arr);
        System.out.println(res);
    }

    public static int change(int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                if (i == 0 && arr[i + 1] == 0) {
                    count++;
                    arr[i] = 1;
                } else if (i == len - 1 && arr[i - 1] == 0) {
                    count++;
                    arr[i] = 1;
                } else if (arr[i - 1] == 0 && arr[i + 1] == 0) {
                    count++;
                    arr[i] = 1;
                }
            }
        }
        return count;
    }
}
