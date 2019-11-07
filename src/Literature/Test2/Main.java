package Literature.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Map<Integer, List<Integer>> line = new HashMap<>();
            int n = in.nextInt();
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                if (line.containsKey(x)) {
                    line.get(x).add(y);
                } else {
                    List<Integer> l = new LinkedList<>();
                    l.add(y);
                    line.put(x, l);
                }
                if (line.containsKey(y)) {
                    line.get(y).add(x);
                } else {
                    List<Integer> l = new LinkedList<>();
                    l.add(x);
                    line.put(y, l);
                }
            }
            canArrive(n, line);
        }
    }

    private static void canArrive(int n, Map<Integer, List<Integer>> line) {
        Queue<Integer> path = new LinkedList<>();
        path.offer(1);
        Set<Integer> arrived = new HashSet<>();
        arrived.add(1);
        int count = 0;
        boolean flag = false;
        while (!flag && count < 2 && !path.isEmpty()) {
            int size = path.size();
            for (int i = 0; i < size; i++) {
                int cur = path.poll();
                if (line.containsKey(cur)) {
                    for (Integer next : line.get(cur)) {
                        if (!arrived.contains(next)) {
                            if (next == n) {
                                flag = true;
                                break;
                            }
                            path.offer(next);
                        }
                    }
                }
            }
            count++;
        }
        if (flag) {
            System.out.println("POSSIBLE");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
/*
1
4 3
1 2
2 4
3 4
 */