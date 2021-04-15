package com.learn.algorithm.string;

/**
 * @author zhaoyue23
 * @create 2021/4/15
 * @since 1.0.0
 */
public class Solution415 {

    public static String addStrings(String num1, String num2) {
        if(num1 == null) {
            return num2;
        }
        if(num2 == null) {
            return num1;
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i >=0 || j >=0 || add > 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = a + b + add;
            sb.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(addStrings("123","7898"));
    }
}
