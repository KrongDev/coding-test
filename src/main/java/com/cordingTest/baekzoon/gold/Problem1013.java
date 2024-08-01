package com.cordingTest.baekzoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(100+1+|01)+";
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while ((T--) > 0) {
            String str = br.readLine();
            if(str.matches(regex)) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
