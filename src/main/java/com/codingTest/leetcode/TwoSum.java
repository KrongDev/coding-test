package com.codingTest.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> arr = new HashMap<>();
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            if(arr.containsKey(nums[i])) {
                return new int[] {arr.get(nums[i]), i};
            }
            arr.put(target-nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
