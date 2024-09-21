package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int aLen = a.length();
        int bLen = b.length();

        int[] arr = new int[26];

        for(int i = 0; i < aLen; i++) {
            arr[a.charAt(i) - 'a']++;
        }

        for(int i = 0; i < bLen; i++) {
            arr[b.charAt(i) - 'a']--;
        }

        int res = 0;
        for(int count: arr) {
            if(count != 0)
                res+= Math.abs(count);
        }

        System.out.println(res);
    }
}
