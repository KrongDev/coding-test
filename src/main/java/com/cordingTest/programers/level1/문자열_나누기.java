package com.cordingTest.programers.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_나누기 {
    public static void main(String[] args) throws IOException {
        문자열_나누기 solution = new 문자열_나누기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = solution.solution(br.readLine());
        System.out.println(res);
    }

    public int solution(String s) {
        int res = 0;
        int len = s.length();
        Character x = null;
        int xCount = 0;
        for(int i = 0; i < len; i++) {
            char sChar = s.charAt(i);
            if(x == null) {
                x = sChar;
                xCount++;
            } else if(x == sChar) {
                xCount++;
            } else {
                xCount--;
                if(xCount == 0) {
                    x = null;
                    res++;
                }
            }
        }
        if(xCount > 0) res++;
        return res;

    }
}
