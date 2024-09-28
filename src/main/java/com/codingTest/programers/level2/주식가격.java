package com.codingTest.programers.level2;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
            answer[i] = search(i, prices);
        }
        return answer;
    }

    public int search(int now, int[] prices) {
        int length = prices.length;
        int down = 0;
        int nowPrice = prices[now];
        for(int i = now + 1; i < length; i++) {
            down++;
            if(prices[i] < nowPrice) return down;
        }
        return length - (now + 1);
    }
}
