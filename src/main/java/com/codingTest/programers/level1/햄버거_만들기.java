package com.codingTest.programers.level1;


public class 햄버거_만들기 {

    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;

        for(int i: ingredient) {
            stack[sp++] = i;
            if(sp >= 4
                && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1
            ) {
                sp -=4;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        햄버거_만들기 res = new 햄버거_만들기();
        System.out.println(res.solution(ingredient));
    }
}
