package com.codingTest.leetcode;

import java.util.List;
import java.util.ArrayList;

public class Letter_Combinations_of_a_Phone_Number {
    char[][] map = new char[][] {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    private List<String> res;
    private StringBuilder sb;
    private int len;

    private void makeCase(String digits, int def) {
        if(len == def) {
            res.add(sb.toString());
            sb.delete(def - 1, def);
            return;
        }
        int num = digits.charAt(def) - '0';
        for(char c: map[num]) {
            sb.append(c);
            makeCase(digits, def + 1);
            sb.delete(def, def + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        this.len = digits.length();

        makeCase(digits, 0);

        return res;
    }
}
