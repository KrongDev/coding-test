package com.codingTest.leetcode;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Parentheses {
    private final Map<Character, Character> parentheses;

    public Valid_Parentheses() {
        parentheses = new HashMap<>();
        parentheses.put(')', '(');
        parentheses.put('}', '{');
        parentheses.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
                continue;
            }

            if(stack.isEmpty() || stack.pop() != parentheses.get(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        Valid_Parentheses v = new Valid_Parentheses();
        bw.write("" + v.isValid(str));
        bw.flush();
        bw.close();
        br.close();
    }
}
