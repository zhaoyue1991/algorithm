package com.learn.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhaoyue23
 * @create 2021/3/13
 * @since 1.0.0
 */
public class Solution20 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(8);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!map.get(pop).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("()[]{}"));
        System.out.println(new Solution20().isValid("([)]"));
        System.out.println(new Solution20().isValid(")]"));

    }
}
