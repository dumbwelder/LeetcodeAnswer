package Xiaomi.Test1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {
        if (prices == null || prices.length == 0) return 0;
        int[] count = new int[budget + 1];
        Arrays.fill(count, budget + 1);
        count[0] = 0;
        for (int p : prices) {
            for (int i = p; i <= budget; i++) {
                count[i] = Math.min(count[i - p] + 1, count[i]);
            }
        }
        return (count[budget] == budget + 1) ? -1 : count[budget];

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for (int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
