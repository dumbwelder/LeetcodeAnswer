package q46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//使用boolean数组作为标记
public class Solution2 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> result = new LinkedList<>();
        int len = nums.length;
        boolean[] visited = new boolean[nums.length];
        per(result, nums, visited, len);
        return res;
    }

    public void per(List<Integer> result, int[] nums, boolean[] visited,  int len) {
        if (result.size() == len) {
            res.add(new ArrayList<>(result));
        } else {
            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result.add(nums[i]);
                    per(result, nums, visited, len);
                    result.remove((Object)nums[i]);
                    visited[i] = false;

                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        List<List<Integer>> res = new Solution2().permute(nums);
        for (List<Integer> l : res) {
            for (Integer i : l) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }
}
