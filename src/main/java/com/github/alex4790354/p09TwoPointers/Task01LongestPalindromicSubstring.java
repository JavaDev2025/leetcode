package com.github.alex4790354.p09TwoPointers;

/** Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.

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

    // function to find the longest palindrome substring
    static String getLongestPal(String s) {

        int n = s.length();
        int start = 0, maxLen = 1;
        for (int i = 0; i < n; i++) {
            // this runs two times for both odd and even
            // length palindromes.
            // j = 0 means odd and j = 1 means even length
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;

                // expand substring while it is a palindrome
                // and in bounds
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high))
                {
                    int currLen = high - low + 1;
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "bbcde";
        System.out.println(getLongestPal(s));
    }

}
