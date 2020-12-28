package com.learn.algorithm.string;

/**
 * @author zhaoyue23
 * @create 2020/12/28
 * @since 1.0.0
 */
public class Solution58 {

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
