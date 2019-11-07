package Ali.test2;

import java.util.Scanner;

//bggbggbbg
// 3
public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String getIndexAndLongest(String users, int max) {
        char[] chs = users.toCharArray();
        int len = users.length();
        int begin = users.indexOf('g');
        int countGirl = 0;
        int longgest = 0;
        for (int i = begin + 1; begin < len; i++) {
            if (chs[i % len] == 'g') {
                if (countGirl <= max) {
                    countGirl++;
                } else {
                    while (chs[begin] == 'b') {
                        begin++;
                    }
                    begin++;
                    while (chs[begin % len] != 'g') {
                        begin++;
                    }
                }
            }
            if (longgest < i - begin) {
                longgest = i - begin-1;
            }
        }
        return new String(maxBoy(users) + " " + (longgest - max));

    }

    public static int maxBoy(String users) {
        char[] chs = users.toCharArray();
        int len = users.length();
        int bIndex = users.indexOf('b');
        int max = 0;
        int oldValue = 0;
        int newValue = 0;
        int res = 0;
        for (int i = bIndex + 1; bIndex < len; i++) {
            if (chs[i % len] == 'b') {
                newValue = i - bIndex - 1;
                if (newValue + oldValue > max) {
                    max = newValue + oldValue;
                    res = bIndex;
                }
                bIndex = i;
                oldValue = newValue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        int max = in.nextInt();

        res = getIndexAndLongest(_users, max);
        System.out.println(res);
    }
}
