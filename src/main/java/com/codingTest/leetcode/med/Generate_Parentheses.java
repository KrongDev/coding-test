package com.codingTest.leetcode.med;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder current, int open, int close, int max) {
        if(current.length() == max * 2) {
            res.add(current.toString());
            return;
        }

        if(open < max) {
            current.append("(");
            backtrack(res, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }

        if(close < open) {
            current.append(")");
            backtrack(res, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Generate_Parentheses g = new Generate_Parentheses();
        System.out.println(g.generateParenthesis(3));
    }
}
