import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] a = {1, 3, 2, 2, 5, 2, 3, 7};
        final int res = solver.findLHS(a);
        System.out.println(res);
    }

    private static class Solution {
        public int findLHS(int[] a) {
            Map<Long, Integer> map = new HashMap<>();
            int res = 0;
            for (int i = 0; i < a.length; ++i) {
                map.put((long)a[i], map.getOrDefault((long)a[i], 0) + 1);
                res = Math.max(res, map.get((long) a[i]));
            }
            for (long key : map.keySet()) {
                if (map.containsKey(key + 1)) {
                    res = Math.max(res, map.get(key) + map.get(key + 1));
                }
            }
            return res;
        }
    }
}

