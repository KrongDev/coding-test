package com.codingTest.programers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class 수식_최대화 {
//    public long solution(String expression) {
//        // 우선순위에 맞는 최대값 출력 경우의 수는?
//        long answer = 0;
//        long res;
//        // + > - > *
//        res = plus(expression, (str) -> minus(str, (third) -> multiply(third, Long::parseLong)));
//        answer = comparison(answer, res);
//        // + > * > -
//        res = plus(expression, (str) -> multiply(str, (third) -> minus(third, Long::parseLong)));
//        answer = comparison(answer, res);
//        // - > * > +
//        res = minus(expression, (str) -> multiply(str, (third) -> plus(third, Long::parseLong)));
//        answer = comparison(answer, res);
//        // - > + > *
//        res = minus(expression, (str) -> plus(str, (third) -> multiply(third, Long::parseLong)));
//        answer = comparison(answer, res);
//        // * > + > -
//        res = multiply(expression, (str) -> plus(str, (third) -> minus(third, Long::parseLong)));
//        answer = comparison(answer, res);
//        // * > - > +
//        res = multiply(expression, (str) -> minus(str, (third) -> plus(third, Long::parseLong)));
//        answer = comparison(answer, res);
//        return answer;
//    }
//
//    private long minus(String expression, Function<String, Long> function) {
//        String[] data = expression.split("-");
//        long answer = function.apply(data[0]);
//        for(int i = 1; i < data.length; i++) {
//            answer -= function.apply(data[i]);
//        }
//        return answer;
//    }
//
//    private long plus(String expression, Function<String, Long> function) {
//        String[] data = expression.split("\\+");
//        long answer = function.apply(data[0]);
//        for (int i = 1; i < data.length; i++) {
//            answer += function.apply(data[i]);
//        }
//        return answer;
//    }
//
//    private long multiply(String expression, Function<String, Long> function) {
//        String[] data = expression.split("\\*");
//        long answer = function.apply(data[0]);
//        for(int i = 1; i < data.length; i++) {
//            answer *= function.apply(data[i]);
//        }
//        return answer;
//    }
//
//    private long comparison(long answer, long res) {
//        return max(answer, abs(res));
//    }
//
//    private long abs(long number) {
//        return Math.abs(number);
//    }
//
//    private long max(long number1, long number2) {
//        return Math.max(number1, number2);
//    }

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';

    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(!Character.isDigit(ch)) {
                numbers.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
                operators.add(ch);
                continue;
            }
            sb.append(ch);
        }
        numbers.add(Long.parseLong(sb.toString()));
        long[] result = new long[6];
        result[0] = operation(numbers, operators, PLUS, MINUS, MULTIPLY);
        result[1] = operation(numbers, operators, PLUS, MULTIPLY, MINUS);
        result[2] = operation(numbers, operators, MINUS, PLUS, MULTIPLY);
        result[3] = operation(numbers, operators, MINUS, MULTIPLY, PLUS);
        result[4] = operation(numbers, operators, MULTIPLY, MINUS, PLUS);
        result[5] = operation(numbers, operators, MULTIPLY, PLUS, MINUS);

        long answer = 0;
        for(long res : result) {
            res = Math.abs(res);
            if(res > answer)answer = res;
        }
        return answer;
    }

    private long operation(List<Long> numbers, List<Character> operators, char opr1, char opr2, char opr3) {
        List<Long> nums = copyOf(numbers);
        List<Character> oprs = copyOf(operators);

        actionToOpr(nums, oprs, opr1);
        actionToOpr(nums, oprs, opr2);
        actionToOpr(nums, oprs, opr3);
        return nums.get(0);
    }

    private void actionToOpr(List<Long> numbers, List<Character> operators, char opr) {
        for(int i = 0; i < operators.size(); i++) {
            if(opr != operators.get(i))continue;
            long num = action(numbers.get(i), numbers.get(i + 1), opr);
            numbers.remove(i);
            numbers.remove(i);
            numbers.add(i, num);
            operators.remove(i);
            i--;
        }
    }

    private long action(long num1, long num2, char opr) {
        switch (opr) {
            case PLUS:
                return num1 + num2;
            case MINUS:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            default:
                throw new RuntimeException();
        }
    }

    private <T> List<T> copyOf(List<T> list) {
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        수식_최대화 res = new 수식_최대화();
        String expression = "100-200*300-500+20";
        System.out.println(res.solution(expression));
    }
}
