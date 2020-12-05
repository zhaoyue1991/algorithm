package com.learn.algorithm.binary_tree;

/**
 * @author zhaoyue23
 * @create 2020/12/5
 * @since 1.0.0
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        // 左右高度相等，则左子树是满的
        if (leftH == rightH) {
            return countNodes(root.right) + (1 << leftH);
        } else {
            // 右子树是满的
            return countNodes(root.left) + (1 << rightH);
        }
    }

    public int height(TreeNode root) {
        int height = 0;
        while (root.left != null) {
            root = root.left;
            height++;
        }
        return height;
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
