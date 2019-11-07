package q278;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int m = 1;
        int mid = 0;
        while (m < n) {
            mid = (m + n) >>> 1;
            if (isBadVersion(mid)) {
                m = mid;
            } else {
                n = mid;
            }

        }
        return mid;
    }
}
