package com.codingTest.programers.level1;

import java.time.LocalDate;

public class 문제_2016년 {
    public String solution(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3).toUpperCase();
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        문제_2016년 res = new 문제_2016년();
        System.out.println(res.solution(a, b));
    }
}
