package q46;

import java.util.*;
//使用Set做标记
public class Solution3 {
    List<List<Integer>> res = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> result = new LinkedList<>();
        int len = nums.length;

        per(result, nums, len);
        return res;
    }

    public void per(List<Integer> result, int[] nums, int len) {
        if (result.size() == len) {
            res.add(new ArrayList<>(result));
        } else {
            for (int i : nums) {
                if (!set.contains(i)) {
                    set.add(i);
                    result.add(i);
                    per(result, nums, len);
                    result.remove((Object) i);
                    set.remove(i);

                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new Solution3().permute(nums);
        for (List<Integer> l : res) {
            for (Integer i : l) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }
}
