package com.learn.algorithm.stack;

import java.util.Stack;

/**
 * @author zhaoyue23
 * @create 2021/3/13
 * @since 1.0.0
 */
public class Solution678 {

    public boolean checkValidString(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                star.push(i);
            } else if (c == '(') {
                left.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!star.isEmpty() && !left.isEmpty()) {
            if (star.pop() < left.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }
}
