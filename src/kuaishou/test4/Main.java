package kuaishou.test4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> stones = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stones.add(sc.nextInt());
        }
        findMin(stones);
        System.out.println(min);
    }

    private static void findMin(List<Integer> stones) {
        if (stones.size() == 0) {
            min = 0;
        } else if (stones.size() == 1) {
            min = Math.min(stones.get(0), min);
        } else {
            for (int i = 0; i < stones.size() - 1; i++) {
                for (int j = i + 1; j < stones.size(); j++) {
                    List<Integer> newStones = new LinkedList<Integer>(stones);
                    int value = Math.abs(newStones.get(i) - newStones.get(j));
                    newStones.remove(j);
                    if (value != 0) {
                        newStones.set(i, value);
                    } else {
                        newStones.remove(i);
                    }
                    findMin(newStones);
                }
            }
        }
    }
}
/*
6
2 7 4 1 8 1
 */