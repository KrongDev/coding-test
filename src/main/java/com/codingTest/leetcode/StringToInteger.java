package com.codingTest.leetcode;

public class StringToInteger {

    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;

        int index = 0;
        boolean negative = false;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            negative = s.charAt(0) == '-';
            index++;
        }

        int result = 0;
        while(index < s.length()) {
            if(!Character.isDigit(s.charAt(index))) {
                break;
            }
            int digit = s.charAt(index) - '0';

            if(result > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;

            index++;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("-9999999999999999"));
    }
}
