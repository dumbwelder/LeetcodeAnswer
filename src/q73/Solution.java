package q73;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                flag = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

    }

    //[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1}, {0}
        };
        new Solution().setZeroes(matrix);
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }
}