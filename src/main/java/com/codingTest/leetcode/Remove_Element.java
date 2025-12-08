package com.codingTest.leetcode;

public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int i = 0, len = nums.length;
        for(int j = 0; j < len; j++) {
            if(nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
