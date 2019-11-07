package q40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        //排序，保证后序深度遍历时不增加多余分支
        Arrays.sort(candidates);
        combinationSum2(0, 0, new Stack<Integer>());
        return res;
    }

    private void combinationSum2(int index, int sum, Stack<Integer> stack) {
        if (sum == target) {
            res.add(new LinkedList<>(stack));
        } else if (sum < target) {
            //为不重复的元素增加分支
            for (int i = index; i < candidates.length; i++) {
                //当有重复元素时，不重复增加分支。
                if (i > index && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                //使用临时变量val储存和，节省对sum的操作。
                int val = sum + candidates[i];
                //当后面数字已不可能实现时，提前结束循环
                if (val > target) {
                    break;
                }
                stack.push(candidates[i]);
                combinationSum2(i + 1, val, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] can = {10, 1, 2, 7, 6, 1, 5};
        int t = 8;
        System.out.println(new Solution().combinationSum2(can, t));
    }
}
