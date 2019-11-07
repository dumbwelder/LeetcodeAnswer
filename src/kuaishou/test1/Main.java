package kuaishou.test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        int[][] result = new int[m][5];
        for (int i = 0; i < n; i++) {
            str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                int option = str.charAt(j) - 'A';
                result[j][option]++;
            }
        }
        int res = 0;
        for (int i = 0; i <m ; i++) {
            int max = 0;
            for (int j = 0; j <5 ; j++) {
                max = Math.max(max,result[i][j]);
            }
            res += max*sc.nextInt();
        }
        System.out.println(res);
    }
}
/*

2 4
ABCD
ABCE
1 2 3 4
 */