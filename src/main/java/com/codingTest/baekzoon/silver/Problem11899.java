package com.codingTest.baekzoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11899 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();

        int front = 0;
        int check = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if(c == '(') front ++;
            else if(front > 0) {
                front--;
                check++;
            }
        }
        System.out.println(len - check * 2);
    }
}
