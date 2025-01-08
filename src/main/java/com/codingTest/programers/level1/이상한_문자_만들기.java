package com.codingTest.programers.level1;


public class 이상한_문자_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int checkIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                checkIndex = 0;
                sb.append(" ");
                continue;
            }
            if(checkIndex%2 == 0) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
            checkIndex++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "try hello world";
        이상한_문자_만들기 res = new 이상한_문자_만들기();
        System.out.println(res.solution(s));
    }
}
