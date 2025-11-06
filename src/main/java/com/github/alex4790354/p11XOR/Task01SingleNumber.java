package com.github.alex4790354.p11XOR;

public class Task01SingleNumber {

    private static int xor(int a, int b) {
        return a ^ b;
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = xor(result, num);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbs1 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(numbs1)); // expect 4
    }

}
