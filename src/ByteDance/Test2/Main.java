package ByteDance.Test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer, Character> m = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            m.put(i + 1, (char) ('A' + i));
        }
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.nextLine();
            encode(0, str.toCharArray(), "");
        }
    }

    private static void encode(int index, char[] chs, String str) {
        if (index == chs.length) {
            System.out.println(str);
        } else {
            if (chs[index] != '0') {
                encode(index + 1, chs, str + m.get(chs[index] - '0'));
                if (chs[index] == '1' && index < chs.length - 1) {
                    encode(index + 2, chs, str + m.get((chs[index] - '0') * 10 + chs[index + 1] - '0'));
                } else if (chs[index] == '2' && index < chs.length - 1 && chs[index + 1] <= '6') {
                    encode(index + 2, chs, str + m.get((chs[index] - '0') * 10 + chs[index + 1] - '0'));
                }
            }

        }
    }
}
