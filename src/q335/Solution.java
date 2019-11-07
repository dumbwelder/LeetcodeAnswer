package q335;

public class Solution {
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        if (len == 4) {
            if (x[3] >= x[1] && x[2] <= x[0])
                return true;
            else return false;
        }
        for (int i = 3; i < len; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
            if (i > 3 && x[i - 1] == x[i - 3] && x[i - 4] + x[i] >= x[i - 2])
                return true;
            if (i > 4 && x[i - 3] - x[i - 5] <= x[i - 1] && x[i - 3] >= x[i - 1] && x[i - 2] - x[i - 4] <= x[i] && x[i - 2] >= x[i] && x[i - 2] > x[i - 4])
                return true;
        }
        return false;
    }
}
