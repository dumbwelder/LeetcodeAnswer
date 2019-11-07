package ByteDance.Test1;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/*
4 10 6
> 2 2 <
1 4
1 3
2 4
2 3
1 1
2 2
n数量 m最大值 q次数 l,r子串
 */
/*
6
4
6
4
0
2
 */
/*
7 10 6
> 2 < 5 > 3 <
1 7
1 3
3 5
5 7
1 4
4 7
 */
/*
24
3
0
6
8
15
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] strs = in.nextLine().trim().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            int q = Integer.parseInt(strs[2]);
            String s = in.nextLine();
            String[] str = s.split(" ");
            List<Integer> game = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (str[i].equals(">")) {
                    game.add(-1);
                } else if (str[i].equals("<")) {
                    game.add(-2);
                } else {
                    game.add(Integer.parseInt(str[i]));
                }
            }
            for (int i = 0; i < q; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                play(start, end, game);
            }
        }
    }

    private static void play(int start, int end, List<Integer> game) {
        game = new LinkedList<>(game.subList(start - 1, end));
        int count = 0;
        int curIndex = 0;
        boolean flag = false;
        int direction = 1;
        while (curIndex >= 0 && curIndex < game.size()) {
            if (game.get(curIndex) == -1) {
                if (flag) {
                    game.remove(curIndex);
                } else {
                    flag = true;
                    direction = 1;
                    curIndex++;
                }
            } else if (game.get(curIndex) == -2) {
                if (flag) {
                    game.remove(curIndex);
                } else {
                    flag = true;
                    direction = -1;
                    curIndex--;
                }
            } else if (game.get(curIndex) == 0) {
                flag = false;
                game.remove(curIndex);
            } else {
                int value = game.get(curIndex);
                count += value;
                flag = false;
                game.set(curIndex, value - 1);
                curIndex += direction;
            }
        }
        System.out.println(count);
    }
}
