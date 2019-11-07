package q38;

public class Solution {
    public String countAndSay(int n) {
        StringBuffer pre = new StringBuffer();
        StringBuffer cur = new StringBuffer();
        pre.append('1');
        int num = 1;
        while (num < n) {
            int count = 0;
            char preChar = pre.charAt(0);
            for (int i = 0; i < pre.length(); i++) {
                if (preChar == pre.charAt(i))
                    count++;
                else {
                    cur.append(count);
                    cur.append(preChar);
                    preChar = pre.charAt(i);
                    count = 1;
                }
            }
            cur.append(count);
            cur.append(preChar);
            pre = cur;
            cur = new StringBuffer();
            num++;
        }
        return pre.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <20 ; i++) {
            System.out.println(new Solution().countAndSay(i));
        }

    }
}
