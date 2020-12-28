package com.learn.algorithm.string;

/**
 * @author zhaoyue23
 * @create 2020/12/26
 * @since 1.0.0
 */
public class Solution344 {

    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new Solution344().reverseString(chars);
        System.out.println(chars);
    }
}
