package com.github.alex4790354.p01ArraysAndStrings.p01;

public class T04MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
                //i++;
            } else {
                merged[k++] = nums2[j++];
                //j++;
            }
            //k++;
        }

        while (i < nums1.length) {
            merged[k++] = nums1[i++];
            /*i++;
            k++;*/
        }
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
            /*j++;
            k++;*/
        }


        int len = merged.length;
        if ( len % 2 != 0) {
            return merged[len / 2];
        } else {
            int middleRight = len / 2;
            int middleLeft = middleRight - 1;
            return (merged[middleLeft] + merged[middleRight]) / 2.0;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(T04MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

}
