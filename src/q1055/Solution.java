package q1055;

public class Solution {
    public int shortestWay(String source, String target) {
        int index = 0;
        int count = 0;
        boolean flag = true;
        while (index < target.length() && flag) {
            flag = false;
            for (int i = 0; i < source.length() && index < target.length(); i++) {
                if (source.charAt(i) == target.charAt(index)) {
                    index++;
                    flag = true;
                }
            }
            count++;
        }
        if (index < target.length()) return -1;
        else return count;
    }
}
