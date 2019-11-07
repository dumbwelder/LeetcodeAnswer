package webank.Test3;

import java.util.*;

public class Main {
    static HashMap<Integer, LinkedList<Integer>> path = new HashMap<>();
    static Set<Integer> canArrive = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            creatPath(in.nextInt(), in.nextInt());
        }
        int start = in.nextInt();
        int end = in.nextInt();
        findPath(start, end, new LinkedList<Integer>());
        canArrive.add(end);
        for (int i = 1; i <= n; i++) {
            if (!canArrive.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static void findPath(int start, int end, LinkedList<Integer> list) {
        if (start == end) {
            canArrive.addAll(list);
        } else {
            list.add(start);
            for (Integer next : path.get(start)) {
                if (!list.contains(next)) {
                    if (canArrive.contains(next)) {
                        canArrive.addAll(list);
                    } else {
                        findPath(next, end, new LinkedList<>(list));
                    }
                }
            }
        }
    }

    private static void creatPath(int point1, int point2) {
        if (path.containsKey(point1)) {
            path.get(point1).add(point2);
        } else {
            LinkedList<Integer> arr = new LinkedList<>();
            arr.add(point2);
            path.put(point1, arr);
        }
        if (path.containsKey(point2)) {
            path.get(point2).add(point1);
        } else {
            LinkedList<Integer> arr = new LinkedList<>();
            arr.add(point1);
            path.put(point2, arr);
        }
    }
}
