package com.learn.algorithm.binary_tree;

/**
 * @author zhaoyue23
 * @create 2020/12/3
 * @since 1.0.0
 */
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return sBST(root, val);
    }

    public TreeNode sBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            return sBST(root.right, val);
        }
        if (root.val > val) {
            return sBST(root.left, val);
        }
        return root;
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
