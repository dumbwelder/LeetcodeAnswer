package ByteDance.Test5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = in.nextInt();
            }
            int res = 0;
            int max = 0;
            int minValue;
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                count = 0;
                minValue = height[i + 1];
                for (int j = i + 1; j < n; j++) {
                    if (height[j] >= height[i]) break;
                    else {
                        if (minValue < height[j]) {
                            count++;
                            minValue = height[j];
                        } else if (minValue == height[j] && j == i + 1) {
                            count++;
                        }
                    }
                }
                if (count > max) {
                    max = count;
                    res = i;
                }
            }
            if (max == 0) {
                System.out.println(0);
            } else {
                System.out.println(height[res]);
            }
        }
    }
}
