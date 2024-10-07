package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[] arr;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(len-- > 0) {
            arr = new int[26];
            st = new StringTokenizer(br.readLine());

            String left = st.nextToken();
            int leftLen = left.length();
            String right = st.nextToken();
            int rightLen = right.length();

            if(leftLen != rightLen){
                sb.append("Impossible");
                sb.append("\n");
                continue;
            }

            for(int i = 0; i < rightLen; i++){
                arr[right.charAt(i) - 'a']++;
                arr[left.charAt(i) - 'a']--;
            }

            boolean res = false;
            for(int i : arr) {
                if(i != 0){
                    res = true;
                    break;
                }
            }
            sb.append(res ? "Impossible" : "Possible");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
