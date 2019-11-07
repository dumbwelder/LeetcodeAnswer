package q118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            if (i != 0) {
                for (int j = 1; j < i; j++) {
                    l.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
                l.add(1);
            }
            ans.add(l);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(1);
        l.add(0, 1);
        l.add(0, 2);
        System.out.println(l);
    }
}