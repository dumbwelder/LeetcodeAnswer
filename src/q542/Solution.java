package q542;

public class Solution {
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == -1) {
                    if (matrix[i][j] == 0) {
                        res[i][j] = 0;
                    } else {
                        count(res, matrix, i, j);
                    }
                }
            }
        }
        return res;
    }

    private void count(int[][] res, int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        res[i][j] = m + n;
        for (int[] d : direction) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (res[x][y] != -1) {
                    res[i][j] = Math.min(res[i][j], res[x][y] + 1);
                } else if (matrix[x][y] == 0) {
                    res[x][y] = 0;
                    res[i][j] = Math.min(res[i][j], res[x][y] + 1);
                } else {
                    count(res, matrix, x, y);
                    res[i][j] = Math.min(res[i][j], res[x][y] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = new Solution().updateMatrix(matrix);
        for (int[] a : res) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
