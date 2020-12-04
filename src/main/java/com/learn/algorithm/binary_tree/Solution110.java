package com.learn.algorithm.binary_tree;

/**
 * @author zhaoyue23
 * @create 2020/12/4
 * @since 1.0.0
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左右子树高度差小于2，并且左右子树都是平衡的
        return Math.abs(height(root.left) - height(root.right)) < 2 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
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
