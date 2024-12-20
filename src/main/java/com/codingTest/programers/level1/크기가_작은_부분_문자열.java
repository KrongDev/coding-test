package com.codingTest.programers.level1;

public class 크기가_작은_부분_문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        int repeatLen = t.length() - p.length() + 1;
        int pLen = p.length();
        for(int i = 0; i < repeatLen; i++) {
            boolean flag = true;
            for(int j = 0; j < pLen; j++) {
                if(t.charAt(i + j) > p.charAt(j)) {
                    flag = false;
                    break;
                }

                if(t.charAt(i + j) < p.charAt(j)) {
                    break;
                }
            }
            if(flag) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String t = "500220839878";
        String p = "7";
        크기가_작은_부분_문자열 res = new 크기가_작은_부분_문자열();
        System.out.println(res.solution(t, p));
    }
}
