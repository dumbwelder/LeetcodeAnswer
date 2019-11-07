package q204;

public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrimes(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    public static boolean isPrimes(int n) {
        if (n == 1) return false;
        boolean flag = true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        new Solution2().countPrimes(1000000);
    }
}
