package com.github.alex4790354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {

    public static int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }


    // ===== ПРОСТОЙ ТЕСТ ЧЕРЕЗ MAIN =====
    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result1 = merge(intervals1);
        print(result1); // ожидается [[1,6],[8,10],[15,18]]

        int[][] intervals2 = {{1,4},{4,5}};
        int[][] result2 = merge(intervals2);
        print(result2); // ожидается [[1,5]]

        int[][] intervals3 = {{4,7},{1,4}};
        int[][] result3 = merge(intervals3);
        print(result3); // ожидается [[1,7]]
    }

    // ===== ВСПОМОГАТЕЛЬНЫЙ МЕТОД ДЛЯ ВЫВОДА =====
    private static void print(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }


}
