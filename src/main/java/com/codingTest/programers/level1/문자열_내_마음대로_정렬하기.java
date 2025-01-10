package com.codingTest.programers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);
            if(c1 != c2) return c1 - c2;

            return o1.compareTo(o2);
        });
        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        문자열_내_마음대로_정렬하기 res = new 문자열_내_마음대로_정렬하기();
        System.out.println(Arrays.toString(res.solution(strings, n)));
    }
}
