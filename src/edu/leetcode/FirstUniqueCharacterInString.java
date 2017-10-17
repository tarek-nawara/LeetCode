package edu.leetcode;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final int result = solver.firstUniqChar("leetcode");
        System.out.println(result);
    }

    private static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> ocur = new LinkedHashMap<>();
            Set<Character> repeated = new HashSet<>();
            for (int i = 0; i < s.length(); ++i) {
                if (repeated.contains(s.charAt(i))) continue;
                if (ocur.containsKey(s.charAt(i))) {
                    ocur.remove(s.charAt(i));
                    repeated.add(s.charAt(i));
                } else {
                    ocur.put(s.charAt(i), i);
                }
            }
            if (ocur.isEmpty()) return -1;
            else return ocur.entrySet().iterator().next().getValue();
        }
    }
}
