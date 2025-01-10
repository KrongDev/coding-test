package com.codingTest.programers.level1;

public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        int pointer = 0;
        for(char c : s.toCharArray()) {
            if(c == 'y' || c == 'Y') pointer++;
            else if (c == 'p' || c == 'P') pointer--;
        }

        return pointer == 0;
    }

    public static void main(String[] args) {
        문자열_내_p와_y의_개수 res = new 문자열_내_p와_y의_개수();
        String s = "pPoooyY";
        System.out.println(res.solution(s));
    }
}
