package q78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        subsets(result, res, nums, 0);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> res, int[] nums, int begin) {
        result.add(new ArrayList<>(res));
        for (int i = begin; i < nums.length; i++) {
            res.add(nums[i]);
            subsets(result, res, nums, i + 1);
            res.remove((Object) nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = new Solution().subsets(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }
}
