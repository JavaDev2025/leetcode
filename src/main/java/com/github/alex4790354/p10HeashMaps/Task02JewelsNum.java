package com.github.alex4790354.p10HeashMaps;

import java.util.HashSet;
import java.util.Set;

public class Task02JewelsNum {

    /** Given two strings of lowercase Latin characters: string J and string S. The characters in string J are "jewels,"
     * while those in string S are "stones." We need to determine how many characters from S are also "jewels." Simply put,
     * we need to check how many characters from S are included in J.
     */

    private static Set<String> buildJewelSet(String j) {
        Set<String> set = new HashSet<>();
        if (j == null) return set;

        for (char c : j.toCharArray()) {
            set.add(String.valueOf(c));
        }
        return set;
    }

    private static boolean isJewel(Set<String> jewelSet, char sCh) {
        return jewelSet.contains(String.valueOf(sCh));
    }

    public static int numbJewelsInStones(String j, String s) {
        if (s == null || s.isEmpty())
            return 0;

        Set<String> jewels = buildJewelSet(j);
        int count = 0;

        for (char curChar : s.toCharArray()) {
            if (isJewel(jewels, curChar)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "ab";
        String S = "aabbccd";
        int ans = numbJewelsInStones(J, S);
        System.out.println(ans); // Expect: 4
    }


}
