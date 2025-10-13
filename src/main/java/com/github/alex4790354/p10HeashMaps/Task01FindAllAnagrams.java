package com.github.alex4790354.p10HeashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task01FindAllAnagrams {

    private static Map<String, Integer> buildFreqMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(Character.toString(ch), map.getOrDefault(Character.toString(ch), 0) + 1);
        }
        return map;
    }

    // Уменьшить счётчик символа в карте (удаляем ключ при нуле)
    private static void removeChar(Map<String, Integer> map, char ch) {
        String key = String.valueOf(ch);
        Integer cnt = map.get(key);
        if (cnt == null) return;
        if (cnt == 1) {
            map.remove(key);
        } else {
            map.put(key, cnt - 1);
        }
    }

    public static List<Integer> findAnagram(String str, String p) {
        List<Integer> result = new ArrayList<>();
        if (p == null || str == null || p.length() > str.length())
            return result;

        Map<String, Integer> need = buildFreqMap(p);
        Map<String, Integer> window = new HashMap<>();

        int m = p.length();
        for (int i = 0; i < m; i++) {
            window.put(Character.toString(str.charAt(i)), window.getOrDefault(Character.toString(str.charAt(i)), 0) + 1);
        }

        if (need.equals(window)) {
            result.add(0);
        }

        for (int i = m; i < str.length(); i++) {
            window.put(Character.toString(str.charAt(i)), window.getOrDefault(Character.toString(str.charAt(i)), 0) + 1);
            removeChar(window, str.charAt(i - m));

            if (window.equals(need)) {
                result.add(i - m + 1);
            }
        }

        return result;
    }

    // ===== Простой тест через main =====
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> ans = findAnagram(s, p);
        System.out.println(ans);
    }

}
