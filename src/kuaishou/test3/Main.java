package kuaishou.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class box {
        public int pre;
        public List<Integer> child = new ArrayList<>();
        public boolean isFilled;

        public box(int pre) {
            this.pre = pre;
        }
    }

    static box[] boxes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boxes = new box[n + 1];
        boxes[1] = new box(0);
        for (int i = 0; i < n - 1; i++) {
            int pre = sc.nextInt();
            int next = sc.nextInt();
            if (pre > next) {
                int temp = pre;
                pre = next;
                next = temp;
            }
            boxes[next] = new box(pre);
            boxes[pre].child.add(next);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int method = sc.nextInt();
            int box = sc.nextInt();
            if (method == 1) {
                fill(box);
            } else if (method == 2) {
                clean(box);
            } else {
                check(box);
            }
        }
    }

    private static void check(int box) {
        if (boxes[box].isFilled) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void clean(int box) {
        boxes[box].isFilled = false;
        if (boxes[box].pre!=0){
            clean(boxes[box].pre);
        }
    }

    private static void fill(int box) {
        boxes[box].isFilled = true;
        if (boxes[box].child != null) {
            for (int i : boxes[box].child) {
                fill(i);
            }
        }
    }
}
/*
6
2 7 4 1 8 1
 */