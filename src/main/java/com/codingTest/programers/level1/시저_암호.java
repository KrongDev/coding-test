package com.codingTest.programers.level1;

public class 시저_암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' ') {
                sb.append(" ");
                continue;
            }
            if(c < 97) {
                sb.append((char)((c - 65 + n)%26 + 65));
            } else {
                sb.append((char)((c - 97 + n)%26 + 97));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        시저_암호 res = new 시저_암호();
        System.out.println(res.solution(s, n));
    }
}
