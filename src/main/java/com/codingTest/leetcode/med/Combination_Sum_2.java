package com.codingTest.leetcode.med;

import java.util.*;

public class Combination_Sum_2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> basket = new ArrayList<>();
        dfs(candidates, target, 0, 0, basket, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int total, int index, List<Integer> basket, List<List<Integer>> res) {
        if(total == target) {
            res.add(new ArrayList<>(basket));
            return;
        }

        int current;
        for(int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current = candidates[i];
            if (total + current > target) {
                break;
            }
            basket.add(current);
            dfs(candidates, target, total + current, i + 1, basket, res);
            basket.remove(basket.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_Sum_2 c = new Combination_Sum_2();
        List<List<Integer>> res = c.combinationSum2(new int[]{3,1,3,5,1,1}, 8);
        for(List<Integer> list : res) {
            System.out.print("[");
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
