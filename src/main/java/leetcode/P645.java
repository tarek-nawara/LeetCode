package leetcode;

import java.util.Arrays;

public class P645 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] a = { 1, 2, 2, 4 };
        final int[] res = solver.findErrorNums(a);
        System.out.println(Arrays.toString(res));
    }

    private static class Solution {
        public int[] findErrorNums(int[] a) {
            int n = a.length;
            int originalXor = 0;
            int currentXor = 0;
            long sum = 0;
            for (int i = 0; i <= n; ++i) {
                originalXor ^= i;
            }
            for (int i = 0; i < n; ++i) {
                currentXor ^= a[i];
            }
            int repeatedXorMissing = originalXor ^ currentXor;
            final int repeated = findRepeated(a);
            return new int[]{ repeated, repeatedXorMissing ^ repeated };
        }

        private int findRepeated(int[] a) {
            int repeated = 0;
            for (int i : a) {
                if (a[Math.abs(i) - 1] < 0) repeated = Math.abs(i);
                else a[Math.abs(i) - 1] *= -1;
            }
            return repeated;
        }
    }
}
