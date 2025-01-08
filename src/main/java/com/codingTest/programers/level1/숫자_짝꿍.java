package com.codingTest.programers.level1;

public class 숫자_짝꿍 {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();

        int num = 10;
        int[] xCount = new int[num];
        int[] yCount = new int[num];
        
        for(Character c : X.toCharArray()){
            xCount[c-48]++;
        }
        for(Character c : Y.toCharArray()){
            yCount[c-48]++;
        }
        
        for(int i = 9; i >= 0; i--){
            int repeat = Math.min(xCount[i], yCount[i]);
            for(int j = 0; j < repeat; j++){
                sb.append(i);
            }
        }

        if(sb.length() == 0) return "-1";
        else if(sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
    public static void main(String[] args) {
        String x = "5525";
        String y = "1255";
        숫자_짝꿍 res = new 숫자_짝꿍();
        System.out.println(res.solution(x, y));
    }
}
