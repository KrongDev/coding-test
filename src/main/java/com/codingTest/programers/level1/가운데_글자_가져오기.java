package com.codingTest.programers.level1;

public class 가운데_글자_가져오기 {
    public String solution(String s) {
        return s.substring((s.length() -1)/2, s.length()/2 + 1);
    }

    public static void main(String[] args) {
        가운데_글자_가져오기 res = new 가운데_글자_가져오기();
        String s = "abcde";
        System.out.println(res.solution(s));
    }
}
