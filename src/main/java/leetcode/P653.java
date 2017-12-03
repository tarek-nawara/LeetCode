package leetcode;

public class P653 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        final boolean res = solver.findTarget(root, 10);
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
    }

    private static class TreeNodeWithParent {
        int val;
        TreeNodeWithParent left;
        TreeNodeWithParent right;
        TreeNodeWithParent parent;

        TreeNodeWithParent(int val, TreeNodeWithParent parent, TreeNodeWithParent left, TreeNodeWithParent right) {
            this.val = val;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        TreeNodeWithParent(int val) {
            this(val, null, null, null);
        }
    }

    private static class Solution {
        public boolean findTarget(TreeNode root, int k) {
            TreeNodeWithParent newRoot = preprocessor(root, null);
            TreeNodeWithParent left = findMinNode(newRoot);
            TreeNodeWithParent right = findMaxNode(newRoot);
            while (left != null && right != null && left.val < right.val) {
                int curSum = left.val + right.val;
                if (curSum == k) return true;
                else if (curSum > k) right = findPredecessor(right);
                else left = findSuccessor(left);
            }
            return false;
        }

        private TreeNodeWithParent preprocessor(TreeNode root, TreeNodeWithParent parent) {
            if (root == null) return null;
            TreeNodeWithParent newRoot = new TreeNodeWithParent(root.val);
            newRoot.parent = parent;
            TreeNodeWithParent left = preprocessor(root.left, newRoot);
            TreeNodeWithParent right = preprocessor(root.right, newRoot);
            newRoot.left = left;
            newRoot.right = right;
            return newRoot;
        }

        private TreeNodeWithParent findSuccessor(TreeNodeWithParent node) {
            if (node.right != null) return findMinNode(node.right);
            TreeNodeWithParent parent = node.parent;
            while (parent != null && node == parent.right) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }

        private TreeNodeWithParent findPredecessor(TreeNodeWithParent node) {
            if (node.left != null) return findMaxNode(node.left);
            TreeNodeWithParent parent = node.parent;
            while (parent != null && node == parent.left) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }

        private TreeNodeWithParent findMinNode(TreeNodeWithParent node) {
            TreeNodeWithParent res = node;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }

        private TreeNodeWithParent findMaxNode(TreeNodeWithParent node) {
            TreeNodeWithParent res = node;
            while (res.right != null) {
                res = res.right;
            }
            return res;
        }
    }
}
