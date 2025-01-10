package com.codingTest.programers.level1;

public class 문자열_다루기_기본 {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6)
            return false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "a234";
        문자열_다루기_기본 res = new 문자열_다루기_기본();
        System.out.println(res.solution(s));
    }
}
