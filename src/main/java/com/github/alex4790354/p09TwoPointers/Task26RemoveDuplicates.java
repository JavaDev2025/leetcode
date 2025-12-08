package com.github.alex4790354.p09TwoPointers;

public class Task26RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {


        int writeIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

}
