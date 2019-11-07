package YiTu.Test2;

import java.util.Scanner;
//5 4
//1 2 1 4 1
//1 1 1 1 3
//2 4 1 2 3
//2 5 1 3 2
//5 2 1 5 5
//1 1
//1 3
//1 5
//3 4
public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            System.out.println(click(x, y, arr));
        }
    }

    private static String click(int x, int y, int[][] arr) {
        int res = near(x, y, arr);
        clean(arr);
        if (res == 1) {
            return "only one!";
        } else if (res == 0) {
            return "empty!";
        } else {
            return res + "";
        }
    }

    private static void clean(int[][] arr) {
        for (int col = 0, curCol = 0; col < n; col++) {
            boolean flag = false;
            for (int row = n - 1, curRow = n - 1; row >= 0; row--) {
                if (arr[row][col] != 0) {
                    arr[row][curRow] = arr[row][col];
                    curRow--;
                    flag = true;
                }
            }
            if (flag) curCol++;
        }
    }

    private static int near(int x, int y, int[][] arr) {
        if (arr[x][y] == 0) {
            return 0;
        } else {
            int count = 1;
            int val = arr[x][y];
            count = countNear(x, y, arr, count, val);
            return count;
        }
    }

    private static int countNear(int x, int y, int[][] arr, int count, int val) {
        arr[x][y] = 0;
        for (int[] d : direction) {
            int xCur = x + d[0];
            int yCur = y + d[0];
            if (inArea(xCur, yCur) && arr[xCur][yCur] == val) {
                count++;
                count = countNear(xCur, yCur, arr, count, val);
            }
        }
        return count;
    }

    private static boolean inArea(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
