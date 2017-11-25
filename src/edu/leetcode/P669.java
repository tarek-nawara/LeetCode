package edu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P669 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        final TreeNode newRoot = solver.trimBST(root, 1, 2);
        final List<Integer> res = newRoot.preorder();
        System.out.println(res);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<Integer> preorder() {
            List<Integer> res = new ArrayList<>();
            res.add(val);
            if (left != null) res.addAll(left.preorder());
            if (right != null) res.addAll(right.preorder());
            return res;
        }
    }

    private static class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) return null;
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            if (root.val < L || root.val > R) {
                root = deleteNode(root, root.val);
            }
            return root;
        }

        private TreeNode deleteNode(TreeNode root, int data) {
            if (root == null) return null;
            if (root.val > data) {
                root.left = deleteNode(root.left, data);
                return root;
            }
            if (root.val < data) {
                root.right = deleteNode(root.right, data);
                return root;
            }
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            int minRight = findMin(root.right);
            root.val = minRight;
            root.right = deleteNode(root.right, minRight);
            return root;
        }

        private int findMin(TreeNode root) {
            if (root == null) throw new RuntimeException("find min on null node");
            while (root.left != null) root = root.left;
            return root.val;
        }
    }
}
