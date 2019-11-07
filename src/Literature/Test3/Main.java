package Literature.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            long fa = in.nextLong();
            long fb = in.nextLong();
            int[][] lines = new int[m][4];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 4; j++) {
                    lines[i][j] = in.nextInt();
                }
            }
            minValue(n, m, fa, fb, lines);
        }
    }

    private static void minValue(int n, int m, long fa, long fb, int[][] lines) {
        List<int[]> list = new LinkedList<>();
        for (int[] arr : lines) {
            list.add(arr);
        }

        int maxA = 0;
        int maxB = 0;
        int indexA = 0;
        int indexB = 0;
        while (canNet(list, m)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[2] > maxA) {
                    indexA = i;
                }
                if (list.get(i)[3] > maxB) {
                    indexB = i;
                }
            }
            list.remove(indexA);
            list.remove(indexB);
        }

    }

    private static boolean canNet(List<int[]> list, int m) {
        Set<Integer> roomSet = new HashSet<>();
        boolean flag = false;
        for (int[] arr : list) {
            roomSet.add(arr[0]);
            roomSet.add(arr[1]);
            if (roomSet.size() == m) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
/*
3 3
2 1
1 2 10 15
1 2 4 20
1 3 5 1
 */
//30