package kuaishou.test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = Integer.parseInt(str);

        str = sc.nextLine();
        char[] chs = str.toCharArray();
        int len = str.length();
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 0;
        if (k > 0) {
            while (left <= right && right < len) {
                int leftCount = 1;
                int rightCount = 1;
                while (count < k && right < len) {
                    if (chs[right] == '1') {
                        count++;
                    }
                    right++;
                }
                if (count == k) {
                    while (left <= right && chs[left] != '1') {
                        left++;
                        leftCount++;
                    }
                    while (right < len && chs[right] != '1') {
                        right++;
                        rightCount++;
                    }
                    res += leftCount * rightCount;
                    count--;
                    left++;
                }
            }
        } else if (k == 0) {
            while (right < len) {
                if (chs[right] == '0') {
                    count++;
                } else {
                    res += count * (count + 1) / 2;
                    count = 0;
                }
                right++;
            }
            res += count * (count + 1) / 2;
        }
        System.out.println(res);
    }
}
/*
1
1010
 */