package edu.leetcode;

import java.util.Arrays;

public class P556 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final int res = solver.nextGreaterElement(39876);
        System.out.println(res);
    }

    private static class Solution {
        public int nextGreaterElement(int n) {
            String s = String.valueOf(n);
            for (int i = s.length(); i >= 0; --i) {
                String firstCut = s.substring(0, i);
                String secondCut = s.substring(i);
                if (reverseSorted(secondCut)) continue;
                long tmp = Long.parseLong(firstCut + getNextGreater(secondCut));
                if (tmp >= Integer.MAX_VALUE) return -1;
                return (int)tmp;
            }
            return -1;
        }

        private String getNextGreater(String secondCut) {
            int next = -1;
            char[] a = secondCut.toCharArray();
            for (int i = 1; i < a.length; ++i) {
                if (a[i] > a[0] && (next == -1 || a[i] < a[next])) {
                    next = i;
                }
            }
            char tmp = a[0];
            a[0] = a[next];
            a[next] = tmp;
            Arrays.sort(a, 1, a.length);
            return new String(a);
        }

        private boolean reverseSorted(String secondCut) {
            for (int i = 1; i < secondCut.length(); ++i) {
                if (secondCut.charAt(i) > secondCut.charAt(i - 1)) return false;
            }
            return true;
        }
    }
}
