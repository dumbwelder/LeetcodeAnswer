package q63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] count = new int[n];
        boolean xflag = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                xflag = true;
            }
            if (xflag) {
                count[i] = 0;
            } else {
                count[i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0]==1){
                count[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    count[j] = 0;
                } else {
                    count[j] += count[j - 1];
                }
            }
        }
        return count[n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = new Solution().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
}
