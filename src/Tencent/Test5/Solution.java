package Tencent.Test5;

import java.util.ArrayList;

public class Solution {
    int count = 0;
    static ArrayList<String> res = new ArrayList<>();

    public int count(int m, int n, int k) {
        count1("", m, n, k);
        return count;
    }

    public void count1(String s, int m, int n, int k) {
        if (n == 0) {
            res.add(s);
            count++;
        } else if (n < k) {
            String str = s + "白";
            if (m<=0){
                res.add(s);
                count++;
            }
            count1(str, m - 1, n - 1, k);
        } else {
            String str1 = s + "白";
            if (m<=0){
                res.add(s);
                count++;
            }
            count1(str1, m - 1, n - 1, k);
            String str2 = s;
            for (int i = 0; i < k; i++) {
                str2 += "红";
            }
            if (m<=0){
                res.add(s);
                count++;
            }
            count1(str2, m - k, n - k, k);

        }
    }

    public static void main(String[] args) {
        int count = new Solution().count(3, 5, 3);
        System.out.println(count);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
