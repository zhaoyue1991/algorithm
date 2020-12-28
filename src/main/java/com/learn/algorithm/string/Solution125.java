package com.learn.algorithm.string;

/**
 * @author zhaoyue23
 * @create 2020/12/28
 * @since 1.0.0
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution125().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution125().isPalindrome("race a car"));
    }
}
