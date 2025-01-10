package com.codingTest.programers.level1;

import java.util.Arrays;

public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] carr = s.toCharArray();
        Arrays.sort(carr);
        for(int i = carr.length - 1; i >= 0; i--) {
            sb.append(carr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Zbcdefg";
        문자열_내림차순으로_배치하기 res = new 문자열_내림차순으로_배치하기();
        System.out.println(res.solution(s));
    }
}
