package q204;

public class Solution2 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = n - 2;
        boolean[] flag = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (!flag[i]) {
                for (int j = i * i; j < n; j += i) {
                    if (!flag[j]) {
                        flag[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().countPrimes(100));
    }
}
