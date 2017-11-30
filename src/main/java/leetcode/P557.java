package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P557 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final String res = solver.reverseWords("Let's take LeetCode contest");
        System.out.println(res);
    }

    private static class Solution {
        public String reverseWords(String s) {
            String[] split = s.split(" ");
            final List<String> res = Arrays.stream(split)
                    .map(str -> new StringBuilder(str).reverse().toString())
                    .collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            for (String str : res) sb.append(str).append(" ");
            return sb.toString().trim();
        }
    }
}
