package q14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int max = Integer.MAX_VALUE;
        if (strs.length==0) return "";
        for (int i = 0; i <strs.length ; i++) {
            if (strs[i]==null||strs[i].length()==0)
                return "";
            if (max>strs[i].length()){
                max = strs[i].length();
            }
        }
        StringBuffer sb = new StringBuffer();
        int count = 0;
        while (count<max){
            char pre = strs[0].charAt(count);
            for (int i = 1; i <strs.length ; i++) {
                if (strs[i].charAt(count)!=pre){
                    return sb.toString();
                }
            }
            sb.append(pre);
            count++;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
