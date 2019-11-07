package q66;

import java.util.ArrayList;

public class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (temp == 0) {
                res.add(digits[i]);
            } else if (digits[i] == 9 ) {
                res.add(0);
            } else {
                temp =0;
                res.add(digits[i]+1);
            }
        }
        if (temp ==1){
            res.add(1);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i <res.size() ; i++) {
            result[i] = res.get(res.size()-1-i);
        }
        return result;
    }
}
