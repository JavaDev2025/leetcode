package com.github.alex4790354.p09TwoPointers;

public class Task02MostWater {

    public static int area(int[] h, int i, int j) {
        if (i < 0 || j >= h.length || i >= j)
            return 0;
        int height = Math.min(h[i], h[j]);
        return height * (j - i);
    }

    public static int maxArea(int[] higth) {
        int best = 0;
        if (higth == null || higth.length < 2)
            return best;

        int left = 0, right = higth.length - 1;

        while (left < right) {
            best = Math.max(best, area(higth, left, right));
            if (higth[left] < higth[right]) {
                left++;
            } else {
                right--;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(height);
        System.out.println(ans); // Expect 49
    }

}
