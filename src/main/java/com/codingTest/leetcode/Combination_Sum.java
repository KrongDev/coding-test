package com.codingTest.leetcode;

import java.util.List;
import java.util.ArrayList;


public class Combination_Sum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dp(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dp(int[] candidates, int target, int index, int total, List<Integer> basket) {
        if (total > target) return;
        if (total == target) {
            this.res.add(new ArrayList<>(basket));
            return;
        }

        int len = candidates.length;
        for (int i = index; i < len; i++) {
            int current = candidates[i];
            basket.add(current);
            dp(candidates, target, i, total + current, basket);
            basket.remove(basket.size() - 1);
        }
    }
}
