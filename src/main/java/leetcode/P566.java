package leetcode;

public class P566 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[][] nums = {{1, 2}, {3, 4}};
        final int[][] res = solver.matrixReshape(nums, 4, 1);
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[i].length; ++j) {
                if (j > 0) System.out.print(" ");
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    private static class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (nums == null || nums.length == 0) return nums;
            int n = 0;
            for (int i = 0; i < nums.length; ++i) {
                n += nums[i].length;
            }
            if ((long) r * c != n) return nums;
            int[][] res = new int[r][c];
            int idx = 0;
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    res[i][j] = nums[idx / nums[0].length][idx % nums[0].length];
                    ++idx;
                }
            }
            return res;
        }
    }
}
