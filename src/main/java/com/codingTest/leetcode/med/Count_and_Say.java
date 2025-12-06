package com.codingTest.leetcode.med;

public class Count_and_Say {

    public String countAndSay(int n) {
        if(n == 1) return "1";

        return group(countAndSay(n - 1));
    }

    private String group(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1, len = str.length();
        char current;
        for(int i = 0; i < len - 1; i++) {
            current = str.charAt(i);
            if(current != str.charAt(i + 1)) {
                sb.append(count).append(current);
                current = str.charAt(i + 1);
                count = 1;
                continue;
            }
            count++;
        }
        sb.append(count).append(str.charAt(len - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        Count_and_Say c = new Count_and_Say();
        System.out.println(c.countAndSay(4));
    }
}
