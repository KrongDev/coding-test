package com.codingTest.programers.pccp.guest1;

import java.util.HashSet;
import java.util.Set;

public class 둘만의_암호 {
    Set<Integer> skipSet = new HashSet<Integer>();
    public String solution(String s, String skip, int index) {
        for(char c : skip.toCharArray()) {
            skipSet.add((int)c);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            char changeChar = backSpelling(c, index);
            sb.append(changeChar);
        }
        return sb.toString();
    }

    private char backSpelling(char c, int index) {
        int i = 0;
        while(true) {
            i++;
            char check = getChar(c, i);
            if(skipSet.contains((int)check)) {
                continue;
            }
            index--;
            if(index == 0)
                return check;
        }
    }

    private char getChar (char c, int addIndex) {
        return (char)((c - 'a' + addIndex)%26 + 'a');
    }

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        둘만의_암호 res = new 둘만의_암호();
        System.out.println(res.solution(s, skip, index));
    }
}
