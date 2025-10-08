package com.github.alex4790354.p09TwoPointers;

/** Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 */

/**
 * Approach 1: Expand Around Center
 * Each character (and the space between characters) can be the center of a palindrome.
 * Expand the pointers left and right as long as the characters match.
 * Remember the start and length of the maximum palindrome.
 * Time: O(n²), Memory: O(1). *
 */


public class Task01LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, maxlength = 1;

        for (int i = 0; i < s.length(); i++) {
            int[] odd = expandFromCenter(s, i, i);
            int[] even = expandFromCenter(s, i, i + 1);
            int[] lonlger = (odd[1] - odd[0]) > (even[1] - even[0])? odd : even;

            if (lonlger[1] - lonlger[0] > maxlength) {
                start = lonlger[0];
                maxlength = lonlger[1] - lonlger[0];
            }
        }
        return s.substring(start, start + maxlength);
    }

    // expand From Center:
    private static int[] expandFromCenter(String s, int left, int right) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }

    // Check:
    public static void main(String[] args) {
        String s1 = "babaс";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "ac";

        System.out.println("Input: " + s1 + " -> Output: " + longestPalindrome(s1));
        System.out.println("Input: " + s2 + " -> Output: " + longestPalindrome(s2));
        System.out.println("Input: " + s3 + " -> Output: " + longestPalindrome(s3));
        System.out.println("Input: " + s4 + " -> Output: " + longestPalindrome(s4));
    }

}
