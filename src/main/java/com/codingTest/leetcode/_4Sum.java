package com.codingTest.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class _4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return List.of();

        Arrays.sort(nums);

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int a = 0; a < len - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (int b = a + 1; b < len - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                long remainingTarget = (long) target - nums[a] - nums[b];

                int c = b + 1;
                int d = len - 1;

                while (c < d) {
                    long currentSum = (long) nums[c] + nums[d];

                    if (currentSum == remainingTarget) {
                        res.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;

                        while (c < d && nums[c] == nums[c - 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d + 1]) {
                            d--;
                        }

                    } else if (currentSum < remainingTarget) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return res;
    }
}
