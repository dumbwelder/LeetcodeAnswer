package q980;

public class Solution {
    int count = 0;
    int m;
    int n;
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int xStart = 0;
        int yStart = 0;
        int gridCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xStart = i;
                    yStart = j;
                }
                if (grid[i][j] == 0) {
                    gridCount++;
                }
            }
        }
        count(grid, xStart, yStart, gridCount);
        return count;
    }

    public void count(int[][] grid, int xCur, int yCur, int gridCount) {
        if (grid[xCur][yCur] == 2) {
            if (gridCount == 0) {
                count++;
            }
            return;
        } else {
            grid[xCur][yCur] = -1;
            for (int[] d : direction) {
                int x = xCur + d[0];
                int y = yCur + d[1];
                if (inArea(x, y) && grid[x][y] != -1) {
                    if (grid[x][y] == 0) {
                        gridCount--;
                    }
                    count(grid, x, y, gridCount);
                    if (grid[x][y] == 0) {
                        gridCount++;
                    }
                }
            }
            grid[xCur][yCur] = 0;
        }
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {2, 0}};
        int res = new Solution().uniquePathsIII(grid);
        System.out.println(res);
    }
}
