package q20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    private Map<Character,Character> m = new HashMap<>();
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                switch (stack.pop()) {
                    case '(':
                        if (ch == ')')
                            break;
                        return false;
                    case '{':
                        if (ch == '}')
                            break;
                        return false;
                    case '[':
                        if (ch == ']')
                            break;
                        return false;
                }

            }
        }
        if (stack.isEmpty()){
            return true;
        }else return false;

    }
}