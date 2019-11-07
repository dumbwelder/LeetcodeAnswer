package ByteDance.Test4;

import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int[] box = new int[3];
            int[] full = new int[3];
            int maxValue = 0;
            full[0] = in.nextInt();
            full[1] = in.nextInt();
            full[2] = in.nextInt();
            for (int i = 0; i <3 ; i++) {
                maxValue += full[i];
            }
            int target = in.nextInt();
            if (target > maxValue) System.out.println(-1);
            else {
                System.out.println(get(box, full, target));
            }
        }
    }

    private static int get(int[] box, int[] full, int target) {
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(box);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int ii = 0; ii < size; ii++) {
                int[] temp = q.poll();
                if (success(temp, target)) {
                    return count;
                }
                for (int i = 0; i < 3; i++) {
                    if (temp[i] != full[i]) {
                        int[] newBox1 = temp.clone();
                        fill(i, newBox1, full);
                        if (!visited(newBox1)) {
                            q.offer(newBox1);
                        }
                    }
                    if (temp[i] != 0) {
                        int[] newBox2 = temp.clone();
                        poll(i, box, full);
                        if (!visited(newBox2)) {
                            q.offer(newBox2);
                        }
                    }
                    for (int j = 0; j < 3; j++) {
                        if (i != j && temp[i] != 0) {
                            int[] newBox = temp.clone();
                            transfer(i, j, newBox, full);
                            if (!visited(newBox)) {
                                q.offer(newBox);
                            }
                        }
                    }
                }
            }
            count++;
            if (count >= 100) break;
        }
        return -1;
    }

    private static boolean success(int[] box, int target) {
        for (int i : box) {
            if (i == target) return true;
        }
        if (box[0]+box[1]==target||box[0]+box[2]==target||box[1]+box[2]==target){
            return true;
        }
        if (box[0]+box[1]+box[2]==target) return true;
        return false;
    }

    private static void fill(int index, int[] box, int[] full) {
        box[index] = full[index];
    }

    private static void poll(int index, int[] box, int[] full) {
        box[index] = 0;
    }

    private static void transfer(int index1, int index2, int[] box, int[] full) {
        int rest = box[index2];
        box[index2] = Math.min(full[index2], box[index1] + rest);
        box[index1] -= box[index2] - rest;
    }

    private static boolean visited(int[] box) {
        String s = "" + box[0] + box[1] + box[2];
        if (set.contains(s)) return true;
        else {
            set.add(s);
            return false;
        }
    }
}
