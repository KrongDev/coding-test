package com.codingTest.programers.level1;

public class 서울에서_김서방_찾기 {
    public String solution(String[] seoul) {
        int index = 0;
        for(String str : seoul) {
            if("Kim".equals(str)) {
                break;
            }
            index++;
        }
        return String.format("김서방은 %d에 있다", index);
    }

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        서울에서_김서방_찾기 res = new 서울에서_김서방_찾기();
        System.out.println(res.solution(seoul));
    }
}
