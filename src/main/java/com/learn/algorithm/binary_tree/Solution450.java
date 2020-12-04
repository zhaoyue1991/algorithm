package com.learn.algorithm.binary_tree;

/**
 * @author zhaoyue23
 * @create 2020/12/3
 * @since 1.0.0
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            // 要删除的节点在右子树
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            // 要删除的节点在左子树
            root.left = deleteNode(root.left, key);
        } else {
            // 要删除节点root
            if (root.left == null && root.right == null) {
                // 左子树、右子树都为空，直接删除
                root = null;
            } else if (root.right != null) {
                // 有右子树，root的后继节点替换当前root，删除后继节点
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // 只有左子树
                root.val = preSuccessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /**
     * 后继查找
     *
     * @param root
     * @return
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * 前驱查找
     *
     * @param root
     * @return
     */
    public int preSuccessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
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
