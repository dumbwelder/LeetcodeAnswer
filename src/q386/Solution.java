package q386;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<Integer> res = new LinkedList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <=9 ; i++) {
            lexicalOrder(n,i);
        }
        return res;
    }

    private void lexicalOrder(int n, int curVal) {
        if (curVal>n){
            return;
        }else {
            res.add(curVal);
            curVal *=10;
            if (curVal<=n){
                for (int i = 0; i <=9 ; i++) {
                    lexicalOrder(n,curVal+i);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().lexicalOrder(13);
    }
}
