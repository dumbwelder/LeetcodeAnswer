package q326;

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0 || n == 1) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
}