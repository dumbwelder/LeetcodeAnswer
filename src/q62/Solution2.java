package q62;

public class Solution2 {
    public int uniquePaths(int m, int n) {
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[j] += count[j - 1];
            }
        }
        return count[n - 1];
    }

}
