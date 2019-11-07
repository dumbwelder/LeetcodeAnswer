package YunCong.Test1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.substring(1, str.length() - 1);
        List<Integer> coins = new LinkedList<>();
        for (String coin : str.split(",")) {
            coins.add(Integer.parseInt(coin.trim()));
        }
        Arrays.sort(coins.toArray());
        int amount = in.nextInt();
        int res = change(coins, amount);
        System.out.println(res);
    }

    private static int change(List<Integer> coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (arr[i] != -1 && arr[i - coin] != -1) {
                    arr[i] = Math.min(arr[i - coin] + 1, arr[i]);
                } else if (arr[i] != -1) {
                    arr[i] = arr[i];
                } else if (arr[i - coin] != -1) {
                    arr[i] = arr[i - coin] + 1;
                }
            }
        }
        return arr[amount];
    }
}
/*
[3]
11
 */