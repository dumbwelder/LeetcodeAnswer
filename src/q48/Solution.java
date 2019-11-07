package q48;

class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i <= (len-1) / 2; i++) {
            for (int j = 0; j < len / 2; j++) {
                int xStart = i;
                int yStart = j;
                int temp = 0;
                int xCurrent = xStart;
                int yCurrent = yStart;
                int prev = matrix[xStart][yStart];
                do {
                    int xNext = yCurrent;
                    int yNext = len - 1 - xCurrent;
                    temp = matrix[xNext][yNext];
                    matrix[xNext][yNext] = prev;
                    xCurrent = xNext;
                    yCurrent = yNext;
                    prev = temp;
                } while (xStart != xCurrent || yStart != yCurrent);
            }
        }
    }
}
