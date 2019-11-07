package mihayou.test1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int numOfZero = 0;
        int chance = 0;
        int curNum = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                numOfZero++;
                chance++;
            } else if (arr[i] == curNum || curNum == 0) {
                curNum = arr[i];
                continue;
            } else if (arr[i] == curNum + 1) {
                curNum++;
            } else if (chance != 0) {
                chance--;
                continue;
            } else {
                flag = false;
                System.out.println("NO+" + numOfZero);
                break;
            }
        }
        if (flag) {
            System.out.println("YES+" + numOfZero);
        }
    }
}