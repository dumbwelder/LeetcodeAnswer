package q79;

public class Solution {
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m;
    int n;
    char[][] board;
    String word;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        if (word.length() == 0) return true;
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if (find(i, j, 1)) return true;
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean find(int i, int j, int cur) {
        if (cur == word.length()) {
            return true;
        } else {
            boolean flag = false;
            for (int k = 0; k < direction.length && !flag; k++) {
                int x = i + direction[k][0];
                int y = j + direction[k][1];
                if (inArea(x, y) && !used[x][y] && board[x][y] == word.charAt(cur)) {
                    used[x][y] = true;
                    flag = find(x, y, cur + 1);
                    used[x][y] = false;
                }
            }
            return flag;
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
