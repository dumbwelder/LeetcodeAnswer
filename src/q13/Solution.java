package q13;

public class Solution {
    public int romanToInt(String s) {
        char[] chs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            switch (chs[i]) {
                case 'I':
                    if (i != chs.length - 1 && (chs[i + 1] == 'V' || chs[i + 1] == 'X')) {
                        count--;
                    } else count++;
                    break;
                case 'V':
                    count += 5;
                    break;
                case 'X':
                    if (i != chs.length - 1 && (chs[i + 1] == 'L' || chs[i + 1] == 'C')) {
                        count -= 10;
                    } else count += 10;
                    break;
                case 'L':
                    count += 50;
                    break;
                case 'C':
                    if (i != chs.length - 1 && (chs[i + 1] == 'D' || chs[i + 1] == 'M')) {
                        count -= 100;
                    } else count += 100;
                    break;
                case 'D':
                    count += 500;
                    break;
                case 'M':
                    count += 1000;
                    break;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String str = "IM";
        int res = new Solution().romanToInt(str);
        System.out.println(res);
    }
}
