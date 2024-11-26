package com.codingTest.programers.pccp.guest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 외톨이_알파벳 {
    public String solution(String input_string) {
        int len = input_string.length();

        if(len == 1) {
            return "N";
        }

        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        SortedSet<Character> sortedSet = new TreeSet<>();

        set.add(input_string.charAt(0));
        stack.push(input_string.charAt(0));

        for( int i = 1; i < len; i++ ) {
            char c = input_string.charAt(i);
            if(set.contains(c)) {
                if(stack.peek() != c) {
                    sortedSet.add(c);
                }
            } else {
                set.add(c);
            }
            stack.add(c);
        }

        if(sortedSet.isEmpty()) return "N";

        StringBuilder sb = new StringBuilder();
        sortedSet.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        외톨이_알파벳 res = new 외톨이_알파벳();
        System.out.println(res.solution(str));
    }
}
