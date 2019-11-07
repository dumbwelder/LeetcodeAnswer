package q46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> result = new LinkedList<>();
        int len = nums.length;
        int used = 0;
        per(result, nums, used, len);
        return res;
    }

    public void per(List<Integer> result, int[] nums, int used, int len) {
        if (result.size() == len) {
            res.add(new ArrayList<>(result));
        } else {
            for (int i = 0; i < len; i++) {
                if (((used >>> i) & 1) == 0) {
                    used = used ^ (1 << i);
                    result.add(nums[i]);
                    per(result, nums, used, len);
                    result.remove((Object) nums[i]);
                    used = used ^ (1 << i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new Solution4().permute(nums);
        for (List<Integer> l : res) {
            for (Integer i : l) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }
}
