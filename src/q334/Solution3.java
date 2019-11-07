package q334;

public class Solution3 {
    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= one) {
                one = n;
            } else if (n <= two) {
                two = n;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,-1,4};
        new Solution3().increasingTriplet(nums);
    }
}

