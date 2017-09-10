import java.util.function.BiFunction;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] a = {1, 3, 2, 2, 5, 2, 3, 7};
        final int res = solver.findLHS(a);
        System.out.println(res);
    }

    private static class Solution {
        private class SegTree {
            private int[] input;
            private int[] segTree;
            public BiFunction<Integer, Integer, Integer> mergeFunction;
            public int rangeQueryBaseCaseElement;

            public void buildTree(int[] input,
                                  BiFunction<Integer, Integer, Integer> mergeFunction,
                                  int rangeQueryBaseCaseElement) {
                this.input = input;
                this.segTree = new int[input.length * 4 + 1];
                this.mergeFunction = mergeFunction;
                this.rangeQueryBaseCaseElement = rangeQueryBaseCaseElement;
                this.buildTree(0, input.length - 1, 0);
            }

            public void buildTree(int low, int high, int pos) {
                if (low == high) {
                    segTree[pos] = input[low];
                    return;
                }
                int mid = low + (high - low) / 2;
                buildTree(low, mid, 2 * pos + 1);
                buildTree(mid + 1, high, 2 * pos + 2);
                segTree[pos] = mergeFunction.apply(segTree[2 * pos + 1], segTree[2 * pos + 2]);
            }

            private int rangeQuery(int low, int high, int qlow, int qhigh, int pos) {
                if (qlow <= low && qhigh >= high) {
                    return segTree[pos];
                }
                if (qlow > high || qhigh < low) {
                    return rangeQueryBaseCaseElement;
                }
                int mid = low + (high - low) / 2;
                int leftRes = rangeQuery(low, mid, qlow, qhigh, 2 * pos + 1);
                int rightRes = rangeQuery(mid + 1, high, qlow, qhigh, 2 * pos + 2);
                return mergeFunction.apply(leftRes, rightRes);
            }

            public int rangeQuery(int qlow, int qhigh) {
                return rangeQuery(0, input.length - 1, qlow, qhigh, 0);
            }
        }

        public int findLHS(int[] a) {
            SegTree minSegTree = new SegTree();
            SegTree maxSegTree = new SegTree();
            minSegTree.buildTree(a, Math::min, Integer.MAX_VALUE);
            maxSegTree.buildTree(a, Math::max, Integer.MIN_VALUE);
            int left = 0;
            int max = a[0];
            int min = a[0];
            int res = 1;
            for (int right = 1; right < a.length; ++right) {
                max = Math.max(max, a[right]);
                min = Math.min(min, a[right]);
                while (max - min > 1) {
                    ++left;
                    max = maxSegTree.rangeQuery(left, right);
                    min = minSegTree.rangeQuery(left, right);
                }
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }
}

