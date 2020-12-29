package com.learn.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoyue23
 * @create 2020/12/28
 * @since 1.0.0
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int total = 0;
        Set<Character> set = new HashSet<>();
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length()) {
                if (!set.contains(s.charAt(right))) {
                    set.add(s.charAt(right));
                    right++;
                } else {
                    break;
                }
            }
            total = Math.max(total, set.size());
            set.remove(s.charAt(i));
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring_1(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int total = 0;
        Set<Character> set;
        for (int i = 0; i < s.length(); i++) {
            set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            total = Math.max(total, set.size());
        }
        return total;
    }
}
