package q26;

public class Solution {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        if (nums != null) {
            int count = 0;
            if (nums.length > 0) {
                int lastValue = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] == lastValue) {
                        count++;
                    }
                    lastValue = nums[i];
                    nums[i - count] = nums[i];
                }
            }
            return nums.length - count;
        } else {
            return -1;
        }

    }
}
