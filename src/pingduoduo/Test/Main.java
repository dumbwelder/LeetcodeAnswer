package pingduoduo.Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            multyGame(sc.nextInt(), sc.nextInt());
        }
    }

    private static void multyGame(int a, int target) {
        Set<Integer> haveTried = new HashSet<>();
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        haveTried.add(a);
        Boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            for (int i = 0; i < size && !flag; i++) {
                int curNum = queue.poll();
                if (isPossible(curNum, target)) {
                    if (curNum == target) {
                        flag = true;
                    } else {
                        if (haveTried.add(curNum * 2)) {
                            queue.offer(curNum * 2);
                        }
                        if (haveTried.add(curNum * 10 + 1)) {
                            queue.offer(curNum * 10 + 1);
                        }
                    }
                }
            }
            if (!flag) {
                res++;
            }
        }
        if (flag) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isPossible(int curNum, int target) {
        if (curNum == 0) {
            return target > 0;
        } else {
            return (target / curNum > 0);
        }
    }
}
/*
3
1 1
1 22
1 3
 */