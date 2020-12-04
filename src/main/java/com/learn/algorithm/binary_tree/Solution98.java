package com.learn.algorithm.binary_tree;

/**
 * @author zhaoyue23
 * @create 2020/12/3
 * @since 1.0.0
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && min >= root.val) {
            return false;
        }
        if (max != null && max <= root.val) {
            return false;
        }
        return isBST(root.left, min, root.val) &&
                isBST(root.right, root.val, max);
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

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
