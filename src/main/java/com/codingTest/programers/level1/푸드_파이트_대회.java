package com.codingTest.programers.level1;

public class 푸드_파이트_대회 {

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<food.length; i++) {
            if(food[i]/2 == 0) continue;
            sb.append(String.valueOf(i).repeat(food[i]/2));
        }
        return sb.toString() + "0" + sb.reverse();
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        푸드_파이트_대회 res = new 푸드_파이트_대회();
        System.out.println(res.solution(food));
    }
}
