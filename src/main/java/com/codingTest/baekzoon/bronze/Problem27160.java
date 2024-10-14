package com.codingTest.baekzoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem27160 {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map.put("STRAWBERRY", 0);
        map.put("BANANA", 1);
        map.put("LIME", 2);
        map.put("PLUM", 3);

        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        StringTokenizer st;
        while (len-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            arr[map.get(str)] += count;
        }
        boolean check = false;
        for(int a: arr) {
            if(a == 5) {
                check = true;
                break;
            }
        }
        System.out.println(check ? "YES" : "NO");
    }
}
