package com.codingTest.programers.level1;

import java.util.Arrays;
import java.util.Stack;

public class 주식_가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            // Stack의 값이 현재 가격보다 작거나 같으면 정상 작동
            while(stack.size() > 0 && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] =  i - stack.pop();
            }

            stack.push(i);
        }

        while(stack.size() > 0) {
            answer[stack.peek()] =  answer.length - 1 - stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        주식_가격 res = new 주식_가격();
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(res.solution(prices)));
    }
}
