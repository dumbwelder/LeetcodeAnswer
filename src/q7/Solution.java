package q7;

public class Solution {
    public int reverse(int x) {
        int y = 0;
        while (x / 10 != 0) {
            y = 10 * y + x % 10;
            x = x / 10;
        }
        if (Integer.MIN_VALUE / 10 > y || (Integer.MIN_VALUE / 10 == y && x < -8)) {
            return 0;
        }
        if (Integer.MAX_VALUE / 10 < y || (Integer.MAX_VALUE / 10 == y && x > 7)) {
            return 0;
        }
        y = y * 10 + x;
        return y;
    }

    public static void main(String[] args) {
        System.out.println(-8 / 10);
    }
}
