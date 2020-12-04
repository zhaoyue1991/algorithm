package com.learn.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyue23
 * @create 2020/12/3
 * @since 1.0.0
 */
public class Solution102_1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    public void dfs(TreeNode root, int height, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (list.size() - 1 >= height) {
            List<Integer> temps = list.get(height);
            temps.add(root.val);
        } else {
            List<Integer> temps = new ArrayList<>();
            temps.add(root.val);
            list.add(temps);
        }
        dfs(root.left, height + 1, list);
        dfs(root.right, height + 1, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
