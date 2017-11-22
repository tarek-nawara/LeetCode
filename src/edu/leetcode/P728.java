package edu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P728 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final List<Integer> res = solver.selfDividingNumbers(1, 22);
        System.out.println(res);
    }

    private static class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            final List<Integer> res = new ArrayList<>();
            for (int i = left; i <= right; ++i) {
                if (isSelfDividing(i)) res.add(i);
            }
            return res;
        }

        private boolean isSelfDividing(int num) {
            final String s = String.valueOf(num);
            if (s.contains("0")) return false;
            for (int i = 0; i < s.length(); ++i) {
                int dnum = s.charAt(i) - '0';
                if (num % dnum != 0) return false;
            }
            return true;
        }
    }
}
