package com.codingTest.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        boolean negative = x < 0;
        while(x != 0) {
            int digit = x % 10;
            if(negative ? result < (Integer.MIN_VALUE - digit) / 10 : result > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            result = result * 10 + digit;
            x = x/10;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));
    }
}
