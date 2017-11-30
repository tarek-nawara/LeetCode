package leetcode;

public class P617 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    class Solution {
        public TreeNode mergeTrees(TreeNode rootOne, TreeNode rootTwo) {
            if (rootOne == null && rootTwo == null) return null;
            if (rootOne == null) return rootTwo;
            if (rootTwo == null) return rootOne;
            final TreeNode newRoot = new TreeNode(rootOne.val + rootTwo.val);
            newRoot.left = mergeTrees(rootOne.left, rootTwo.left);
            newRoot.right = mergeTrees(rootOne.right, rootTwo.right);
            return newRoot;
        }
    }
}
