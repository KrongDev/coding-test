package com.codingTest.leetcode.easy;

public class Count_odd_Numbers_in_a_Interval_Range {
    public int countOdds(int low, int high) {
        int count = (high-low)/2;
        return (low%2 == 1 || high%2 == 1) ? count + 1 : count;
    }

    public static void main(String[] args) {
        Count_odd_Numbers_in_a_Interval_Range obj = new Count_odd_Numbers_in_a_Interval_Range();
        System.out.println(obj.countOdds(2, 2));
    }
}
