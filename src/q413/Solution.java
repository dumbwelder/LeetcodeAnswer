package q413;

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int len = A.length;

        for (int i = 0, j = i + 2; i < len - 2; i = j - 1, j = i + 2) {
            while (j < len && 2 * A[j - 1] - A[j - 2] == A[j]) {
                count += j - i - 1;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 9, 10};
        new Solution().numberOfArithmeticSlices(arr);
    }
}
