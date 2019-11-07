package EightQueen;

public class Solution {
    public static int[] arr = new int[8];//棋盘，放皇后
    public static int count = 0;//存储方案结果数量

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("八皇后问题");
        findQueen(0);
        System.out.println("八皇后问题共有：" + count + "种可能");
    }

    private static void findQueen(int row) {
        if (row > 7) {
            print();
            count++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            arr[row] = i;
            if (check(row)) {
                findQueen(row + 1);
            }
        }
    }

    private static void print() {
        System.out.println(arr);
    }

    private static boolean check(int row) {
        //列冲突
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row])
                return false;
        }
        //正对角线
        for (int i = 0; i <row ; i++) {
            if (arr[i]==arr[row]-row+i) return false;
        }
        //反对角线
        for (int i = 0; i <row ; i++) {
            if (arr[i] == arr[row]+row-i) return false;
        }
        return true;
    }

}
