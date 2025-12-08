package com.codingTest.leetcode;

import java.util.Arrays;

public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;

        int res = nums[0] + nums[1] + nums[2];
        if(len == 3) return res;
        int l, r, sum;
        for(int x = 0; x < len - 2; x++) {
            if (x > 0 && nums[x] == nums[x - 1]) continue;

            l = x + 1;
            r = len - 1;
            while(l < r) {
                sum = nums[x] + nums[l] + nums[r];

                if(Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (sum < target) l++;
                else if (sum > target) r--;
                else return sum;
            }
        }

        return res;
    }

}
