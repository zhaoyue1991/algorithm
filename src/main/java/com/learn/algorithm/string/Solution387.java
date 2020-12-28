package com.learn.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyue23
 * @create 2020/12/28
 * @since 1.0.0
 */
public class Solution387 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
