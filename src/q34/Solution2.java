package q34;

public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                res[0] = mid;
                while (res[0] > 0 && nums[res[0] - 1] == target) {
                    res[0]--;
                }
                res[1] = mid;
                while (res[1] < nums.length - 1 && nums[res[1] + 1] == target) {
                    res[1]++;
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(new Solution2().searchRange(nums, target));
    }
}
