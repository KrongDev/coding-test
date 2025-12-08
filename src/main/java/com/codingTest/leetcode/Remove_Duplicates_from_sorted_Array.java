package com.codingTest.leetcode;

public class Remove_Duplicates_from_sorted_Array {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
