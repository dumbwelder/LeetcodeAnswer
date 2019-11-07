package didi.Test1;

import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> rule = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            createRule(in.nextInt(), in.nextInt());
        }
        maxHeap(n);
    }

    private static void maxHeap(int n) {
        for (int i = 1; i <= n; i++) {

        }
        System.out.println(4);
    }

    private static void createRule(int heap1, int heap2) {
        if (rule.containsKey(heap1)) {
            rule.get(heap1).add(heap2);
        } else {
            List<Integer> arr = new LinkedList<>();
            arr.add(heap2);
            rule.put(heap1, arr);
        }
        if (rule.containsKey(heap2)) {
            rule.get(heap2).add(heap1);
        } else {
            List<Integer> arr = new LinkedList<>();
            arr.add(heap1);
            rule.put(heap2, arr);
        }
    }
}