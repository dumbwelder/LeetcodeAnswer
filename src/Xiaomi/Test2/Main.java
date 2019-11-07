package Xiaomi.Test2;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    //1(2(3,4(,5)),6(7,))
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String input) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chs = input.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(' && chs[i + 1] == ',') {
                count++;
            } else if (chs[i] == ',') {
                for (int j = 0; j <2-count ; j++) {
                    sb.append(s.pop());
                }
                count=0;
            } else if (chs[i] == ')'&&chs[i - 1] == ',') {
                count++;
            } else if (chs[i]>='0'&&chs[i]<='9'){
                s.push(chs[i]);
            }
        }
        return sb.toString();
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}

