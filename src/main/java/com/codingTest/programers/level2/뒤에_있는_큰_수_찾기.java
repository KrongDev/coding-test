package com.codingTest.programers.level2;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        뒤에_있는_큰_수_찾기 res = new 뒤에_있는_큰_수_찾기();
        int[] numbers = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(res.solution(numbers)));
    }
}
