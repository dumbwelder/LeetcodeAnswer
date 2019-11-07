package q198;

class Solution {
    public int rob(int[] nums) {
        int max = 0;
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == 1) {
                arr[i] = nums[i];
            } else {
                arr[i] = Math.max(arr[i - 2]+ nums[i], arr[i - 1]) ;
            }
            max = max > arr[i] ? max : arr[i];
        }
        return max;

    }
}
