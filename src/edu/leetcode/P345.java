package edu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P345 {
    public static void main(String[] args) {
        Solution solver = new Solution();
        final String result = solver.reverseVowels("leetcode");
        System.out.println(result);
    }


    private static class Solution {
        private static final class Vowel {
            int position;
            char value;

            Vowel(int position, char value) {
                this.position = position;
                this.value = value;
            }
        }

        public String reverseVowels(String s) {
            char[] a = s.toCharArray();
            final List<Vowel> vowels = new ArrayList<>();
            for (int i = 0; i < s.length(); ++i) {
                if (isVowel(s.charAt(i))) {
                    vowels.add(new Vowel(i, s.charAt(i)));
                }
            }
            reverseVowels(vowels);
            int idx = 0;
            for (int i = 0; i < s.length() && idx < vowels.size(); ++i) {
                if (i == vowels.get(idx).position) {
                    a[i] = vowels.get(idx).value;
                    ++idx;
                }
            }
            return new String(a);
        }

        private boolean isVowel(char a) {
            final char c = Character.toLowerCase(a);
            return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u');
        }

        private void reverseVowels(final List<Vowel> vowels) {
            for (int i = 0; i < vowels.size() / 2; ++i) {
                char temp = vowels.get(i).value;
                vowels.get(i).value = vowels.get(vowels.size() - i - 1).value;
                vowels.get(vowels.size() - i  - 1).value = temp;
            }
        }
    }
}
