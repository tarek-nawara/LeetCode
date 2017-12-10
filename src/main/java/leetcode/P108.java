package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P108 {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        final Solution solver = new Solution();
        final TreeNode res = solver.sortedArrayToBST(nums);
        System.out.println(res.toList());
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        List<Integer> toList() {
            List<Integer> res = new ArrayList<>();
            if (left != null) res.addAll(left.toList());
            res.add(val);
            if (right != null) res.addAll(right.toList());
            return res;
        }
    }

    private static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
            if (lo > hi) return null;
            if (lo == hi) return new TreeNode(nums[lo]);
            int mid = lo + (hi - lo) / 2;
            TreeNode res = new TreeNode(nums[mid]);
            res.left = sortedArrayToBST(nums, lo, mid - 1);
            res.right = sortedArrayToBST(nums, mid + 1, hi);
            return res;
        }
    }
}
