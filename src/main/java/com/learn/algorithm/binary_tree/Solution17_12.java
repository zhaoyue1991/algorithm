package com.learn.algorithm.binary_tree;


/**
 * @author zhaoyue23
 * @create 2020/12/5
 * @since 1.0.0
 */
public class Solution17_12 {
    TreeNode prev = new TreeNode(-1);

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode resultNode = prev;
        mid(root);
        return resultNode.right;
    }

    public void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        prev.right = root;
        root.left = null;
        prev = prev.right;
        mid(root.right);
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
