package pingduoduo.Test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        maxLength(s);
    }

    private static void maxLength(String s) {
        char[] chs = s.toCharArray();
        int len = s.length();
        int[][] flag = new int[len][len];
        boolean isFound;
        int res = 0;
        for (int i = 1; i < len; i += 2) {
            isFound = false;
            for (int j = 0; j < len - i; j++) {
                if (isLegalChar(chs[j], chs[i + j])) {
                    if (i == 1 || flag[j + 1][j + i - 1] > 0) {
                        flag[j][j + i] = i;
                        isFound = true;
                    }
                }
                int mid = j + 1;
                while (mid < i + j) {
                    if (flag[j][mid] > 0 && flag[mid + 1][i + j] > 0) {
                        flag[j][j + i] = i;
                        isFound = true;
                        break;
                    }
                    mid += 2;
                }
            }
            if (!isFound) {
                break;
            } else {
                res += 2;
            }
        }
        System.out.println(res);
    }

    private static boolean isLegalChar(char ch1, char ch2) {
        Map<Character, Character> map = new HashMap<>(2);
        map.put('[', ']');
        map.put('(', ')');
        if (map.containsKey(ch1) && map.get(ch1) == ch2) {
            return true;
        } else {
            return false;
        }
    }
}
/*
([(][()]]()
(())()
 */