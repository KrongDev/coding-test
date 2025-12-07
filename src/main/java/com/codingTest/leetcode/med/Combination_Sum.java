package com.codingTest.leetcode.med;

import java.util.List;
import java.util.ArrayList;


public class Combination_Sum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dp(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dp(int[] candidates, int target, int index, int total, List<Integer> burket) {
        if (total > target) return;
        if (total == target) {
            this.res.add(new ArrayList<>(burket));
            return;
        }

        int len = candidates.length;
        for (int i = index; i < len; i++) {
            int current = candidates[i];
            burket.add(current);
            dp(candidates, target, i, total + current, burket);
            burket.remove(burket.size() - 1);
        }
    }
}
