package q334;
//暴力法，超时，时间复杂度n^3
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] < nums[k]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
