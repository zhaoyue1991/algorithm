package com.learn.algorithm.binary_tree;

/**
 * 二叉树的最大深度
 *
 * @author zhaoyue23
 * @create 2020/12/3
 * @since 1.0.0
 */
public class Solution104_1 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
