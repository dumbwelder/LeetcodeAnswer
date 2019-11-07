package mihayou.test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] box = new int[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                box[i][j] = sc.nextInt() - 'A';
            }
        }
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int temp = box[x1][y1];
        box[x1][y1] = box[x2][y2];
        box[x2][y2] = temp;
        check(box);
    }

    private static void check(int[][] box) {
        int sum = 0;
//        while (true) {
//            checkCol();
//            checkRow();
//    }
    }
}
