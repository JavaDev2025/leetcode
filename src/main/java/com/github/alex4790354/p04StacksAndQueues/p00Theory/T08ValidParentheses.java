package com.github.alex4790354.p04StacksAndQueues.p00Theory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T08ValidParentheses {

    public static boolean isValid(String str) {
        if (str == null || str.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (pairs.containsValue(ch)) {
                stack.push(ch);
            } else if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("((()[]{})"));
    }

}
